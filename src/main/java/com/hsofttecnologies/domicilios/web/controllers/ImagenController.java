package com.hsofttecnologies.domicilios.web.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hsofttecnologies.domicilios.util.FileUtil;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

@RestController
public class ImagenController {

	@Autowired
	FileUtil fileUtil;

	@RequestMapping(value = "api/imagen/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getProductoImagen(@PathVariable("id") int id, HttpServletResponse reponse)
			throws IOException {
		Path imagePath = Paths.get(fileUtil.path + id + ".jpg");
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		byte[] img;
		try{
			img = Files.readAllBytes(imagePath);
		} catch(Exception e) {
			img = Files.readAllBytes(Paths.get(fileUtil.path + "mrk.jpg"));
		}
		return new ResponseEntity<byte[]>(img, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "api/imagen/{id}", method = RequestMethod.POST)
	public ResponseEntity<Respuesta> addProductoImagen(HttpServletResponse reponse, @PathVariable("id") int id,
			@RequestParam("file") MultipartFile imagen) throws IOException {
		Respuesta respuesta = new Respuesta();
		if(imagen.isEmpty()) {
			respuesta.setTipo("Error");
			respuesta.setMensaje("No se ha enviado una imagen");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		} else {
			fileUtil.SaveFile(imagen, id + ".jpg");
			respuesta.setTipo("Confirmacion");
			respuesta.setMensaje("Imagen subida correctamente");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}
}
