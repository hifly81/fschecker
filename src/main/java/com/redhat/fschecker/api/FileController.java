package com.redhat.fschecker.api;

import com.redhat.fschecker.model.FileInput;
import com.redhat.fschecker.model.FileResult;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@ApplicationScoped
@Path("/file")
public class FileController {

	@GET
	@Path("/health")
	@Produces(MediaType.APPLICATION_JSON)
	public Response health() {
		FileResult fileResult = new FileResult();
		fileResult.setMessage("alive");
		return Response.status(Response.Status.OK).entity(fileResult).build();
	}
	
	@POST
	@Path("/content")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(FileInput fileInput) {
		FileResult result = new FileResult();

		java.nio.file.Path tmp = Paths.get(fileInput.getPath());

		try {
			result.setContent(new String(Files.readAllBytes(tmp)));
		} catch (Exception e) {
			result.setMessage(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}

		result.setMessage("File content");
		return Response.status(Response.Status.OK).entity(result).build();

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(FileInput fileInput) {
		FileResult result = new FileResult();

		java.nio.file.Path tmp = Paths.get(fileInput.getPath());

		try {
			Files.delete(tmp);
		} catch (Exception e) {
			result.setMessage(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}

		result.setMessage("File deleted");
		return Response.status(Response.Status.OK).entity(result).build();
	}


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(FileInput fileInput) {

		FileResult result = new FileResult();

		java.nio.file.Path tmp = Paths.get(fileInput.getPath());

		try {
			Files.write(tmp, fileInput.getContent().getBytes(), StandardOpenOption.CREATE);
		} catch (Exception e) {
			result.setMessage(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}

		result.setMessage("File created");
		return Response.status(Response.Status.CREATED).entity(result).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEntry(FileInput fileInput) {
		FileResult result = new FileResult();

		java.nio.file.Path tmp = Paths.get(fileInput.getPath());

		try {
			Files.write(tmp, "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(tmp, fileInput.getContent().getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			result.setMessage(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}

		result.setMessage("Entry added");
		return Response.status(Response.Status.OK).entity(result).build();
	}

}
