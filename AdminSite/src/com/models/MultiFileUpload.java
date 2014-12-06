package com.models;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileUpload {

	  private List<MultipartFile> multiUploadedFileList;
	    
	    public List<MultipartFile> getMultiUploadedFileList() {
	        return multiUploadedFileList;
	    }

	    public void setMultiUploadedFileList(List<MultipartFile> 
	                multiUploadedFileList) {
	        this.multiUploadedFileList = multiUploadedFileList;
	    }   
	    
}
