package com.controllers;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.picketbox.commons.cipher.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import Validadores.CatastrofeValidador;

import com.Controllers.CBasedeDatos;
import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Interfaces.ICBasedeDatos;
import com.Interfaces.ICCatastrofe;
import com.models.CatastrofeListModel;
import com.models.CatastrofeModel;
import com.utils.imagenShow;

@RequestMapping("/catastrofes")
@Controller
public class CatastrofesController {

	 CatastrofeValidador CValidador;

	 @Autowired
	 ServletContext context;


	@Autowired
	public CatastrofesController(CatastrofeValidador CValidador) {
		this.CValidador = CValidador;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String CatastrofesGet(ModelMap model) {
		CatastrofeListModel cModel = new CatastrofeListModel();
		model.addAttribute("CatastrofeListModel", cModel);		
		return "listCatastrofes";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String CatastrofeCreate(ModelMap model) {
		CatastrofeModel cModel = new CatastrofeModel();
		cModel.setAction("Crear");
		model.addAttribute("CatastrofeModel", cModel);
		return "altaCatastrofe";		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String CatastrofeSave(
			@ModelAttribute("CatastrofeModel") CatastrofeModel CatastrofeModel,
			BindingResult bindingResult, HttpServletRequest request) throws Exception {	
		
		String clavesToSave = "";
		String fuentesToSave = "";
		
		//CValidador.validate(CatastrofeModel, bindingResult);
		
		//if (bindingResult.hasErrors()) {
			//return "altaCatastrofe";
		//} else {
			
			if(CatastrofeModel.getAction().equals("Crear")){
			try {
				  
				Date date = new Date();
			      Calendar calendar = Calendar.getInstance();
			      calendar.setTime(date);
			      SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddhhmmss");
			      String tenantIdentifier = "CT" + SDF.format(date);

				//ALta entidad
				Catastrofe cEntity = new Catastrofe();
				cEntity.setActiva(CatastrofeModel.getActiva());
				cEntity.setNombre(CatastrofeModel.getNombre());
				cEntity.setCss(CatastrofeModel.getCss());
				cEntity.setDominio(CatastrofeModel.getDominio());
				cEntity.setFechaCreacion(date);
  			    cEntity.setStringConeccion("jdbc:mysql://localhost:3306/" + tenantIdentifier /*CatastrofeModel.getNombre().trim() + s.replace("-", "").trim()*/);
				cEntity.setInformacion(CatastrofeModel.getInformacion());				
				cEntity.setZonaAfectada(CatastrofeModel.getZonaAfectada());				
				cEntity.setLogo(CatastrofeModel.getLogo().getBytes());
				 //alta tenant en archivo hosts
				 File hosts = new File("C:/Windows/System32/drivers/etc/hosts");			
				 hosts.setWritable(true);
				 BufferedWriter bw = new BufferedWriter(new FileWriter(hosts, true));
				 bw.append(System.getProperty("line.separator"));
				 bw.append("127.0.0.1"+"	" +	CatastrofeModel.getDominio());
				 bw.flush();
				 bw.close();
				 
				 //String altaFecha = cEntity.getNombre() + s.replace("-", "").trim();
				 //String imagenesT = context.getRealPath("/WEB-INF/imagenesT");				 
				 String imagenesT = "C:/imagenesT";
						 
				 File theDir = new File(imagenesT +"/" +tenantIdentifier/* altaFecha*/);

				  // if the directory does not exist, create it
				  if (!theDir.exists()) {
				    System.out.println("creating directory: " + imagenesT);
			        theDir.mkdir();
				    System.out.println("DIR created");				   
				  }
		
					List<MultipartFile> files = CatastrofeModel
							.getMultiUploadedFileList();

					for (MultipartFile multipartFile : files) {
						String fileName = multipartFile.getOriginalFilename();
						multipartFile.transferTo(new File(theDir.getAbsolutePath() + "/" + fileName));
					}
				 
					for (String palabra : CatastrofeModel.getPalabrasList()) {
						clavesToSave += palabra + ";".toString();
					}
					
					for (String fuente : CatastrofeModel.getFuenteDedatosMod()) {
						fuentesToSave += fuente + ";".toString();
					}

					cEntity.setPalabrasClaves(clavesToSave.trim());
					cEntity.setFuentesDatos(fuentesToSave.trim());
					cEntity.setCarpetaImagenes(theDir.getAbsolutePath());
					
					ICCatastrofe ic = new CCatastrofe();
					ICBasedeDatos ib = new CBasedeDatos();
					ic.GuardarCatastrofe(cEntity);	
					ib.CrearTenantDB(tenantIdentifier/*CatastrofeModel.getNombre() + s.replace("-", "").trim()*/);
					ib.CrearTenantTables(tenantIdentifier/*CatastrofeModel.getNombre() + s.replace("-", "").trim()*/);					
				
			} catch (Exception e) {
				throw e;
			}
			
			}else{
				
					ICCatastrofe ic = new CCatastrofe();
					Catastrofe c = ic.getCatastrofeByID((Integer)request.getSession().getAttribute("tenantID"));				
					c.setActiva(CatastrofeModel.getActiva());
					c.setNombre(CatastrofeModel.getNombre());
					c.setCss(CatastrofeModel.getCss());
					c.setDominio(CatastrofeModel.getDominio());
					c.setInformacion(CatastrofeModel.getInformacion());				
					c.setZonaAfectada(CatastrofeModel.getZonaAfectada());
					
					if (CatastrofeModel.getLogo().getSize() > 0 ){
					c.setLogo(CatastrofeModel.getLogo().getBytes());
					}
					
					 File imgFolder = new File(c.getCarpetaImagenes());
					 File[] listOfFiles = imgFolder.listFiles();
					 List<String> toKeep = CatastrofeModel.getImagenesNuevas();
					 List<String> filesm = new ArrayList<String>();
					 
					 for (File file : listOfFiles) {							
						 filesm.add(file.getAbsolutePath());							
						}
					 
					 for (File file : listOfFiles) {							
							if(filesm.contains(file.getAbsolutePath()) && !toKeep.contains(file.getAbsolutePath()))
							{
								file.delete();
							}
					}
					 											
					if(CatastrofeModel.getMultiUploadedFileList().get(0).getSize() != 0){
					
					List<MultipartFile> files = CatastrofeModel
							.getMultiUploadedFileList();

					
					for (MultipartFile multipartFile : files) {
						String fileName = multipartFile.getOriginalFilename();
						multipartFile.transferTo(new File(imgFolder.getAbsolutePath() + "/" + fileName));
					}
					
					}
					for (String palabra : CatastrofeModel.getPalabrasList()) {
						clavesToSave += palabra + ";".toString();
					}
					
					for (String fuente : CatastrofeModel.getFuenteDedatosMod()) {
						fuentesToSave += fuente + ";".toString();
					}

					c.setPalabrasClaves(clavesToSave.trim());
					c.setFuentesDatos(fuentesToSave);
			
					ic.ActualizarCatastrofe(c, (Integer)request.getSession().getAttribute("tenantID"));
					
				return "Result";
			}	
	
 		return "Result";

	}
	
	@RequestMapping(value="/edit/{tenantID}", method = RequestMethod.GET)
	public String CatastrofeUpdate(@PathVariable int tenantID, ModelMap model, HttpServletRequest request) throws Exception {		
			
		request.getSession().setAttribute("tenantID", tenantID);
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(tenantID);
		CatastrofeModel cModel = new CatastrofeModel(c);
		cModel.setAction("Modificar");
		
		File folder = new File(cModel.getCarpetaImagenes());
		File[] listOfFiles = folder.listFiles();

		
		for (File file : listOfFiles) {
			FileInputStream fis=new FileInputStream(file);
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			int b;
			byte[] buffer = new byte[1024];
			while((b=fis.read(buffer))!=-1){
			bos.write(buffer,0,b);
			}
			byte[] fileBytes=bos.toByteArray();
			fis.close();
			bos.close();
			imagenShow i = new imagenShow();
			String encodedString= Base64.encodeBytes(fileBytes);
			i.setByteValue(encodedString);
			i.setPathValue(file.getAbsolutePath());
			cModel.getImagenes().add(i);
			}
		
		String encodedLogo= Base64.encodeBytes(c.getLogo());
		cModel.setLogoString(encodedLogo);

		
		model.addAttribute("CatastrofeModel", cModel);
			return "altaCatastrofe";	

	}

}
