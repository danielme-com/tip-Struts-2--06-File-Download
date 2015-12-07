package com.danielme.tips.struts2.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author danielme.com
 * 
 */
public class FileDownloadAction extends ActionSupport 
{

	private static final long serialVersionUID = 1L;

	private static final String PATH = ServletActionContext.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "test.pdf";
	
	private static final Logger LOGGER = Logger.getLogger(FileDownloadAction.class);
	
	private InputStream pdf = null;
	
	private long contentLength = 0;

	private String contentName;

	
	public String execute()
	{
		return INPUT;
	}


	public String response() 
	{
		File file = new File(PATH);
		
		byte[] result = null;
		try
		{
			result = IOUtils.toByteArray(new FileInputStream(file));
			//las FileUtils de Apache son dependencia de Struts 2
			FileUtils.writeByteArrayToFile(file, result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentLength(result.length);
			response.setContentType("application/pdf");
			//attachment: el fichero se ofrece para descargar
			//inline: se solicita al navegador que lo abra él mismo si tiene el plugin adecuado
			//o puede mostrar el tipo de archivo
			response.setHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
	
			ServletOutputStream out = response.getOutputStream();
			out.write(result);
			out.flush();
		}
		catch (Exception ex)
		{
			LOGGER.error(ex.getMessage(), ex);
			addActionError(ex.getMessage());
			return INPUT;
		}
		return NONE;
	}

	public String resultStream() 
	{
		File file = new File(PATH);
		try 
		{
			this.pdf = new FileInputStream(file);
		} 
		catch (FileNotFoundException ex) 
		{
			LOGGER.error(ex.getMessage(), ex);
			addActionError(ex.getMessage());
			return INPUT;
		}
		this.contentLength = file.length();
		this.contentName = "test.pdf";
		
		return "stream";
	}

	public InputStream getPdf() 
	{
		return this.pdf;
	}	

	public long getContentLength() 
	{
		return this.contentLength;
	}

	public String getContentName() 
	{
		return this.contentName;
	}	

}
