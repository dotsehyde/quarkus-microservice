package com.dotsehyde;

import com.dotsehyde.Models.Student.StudentDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/student")
@Tag(name = "Student Controller", description = "Student Authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    StudentService studentService;

    @POST
    @Operation(summary = "Create new student")
    public Response createStudent(
            @Valid StudentDto.StudentCreate data
    ) {
        return Response.ok(studentService.createStudent(data)).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get student by ID")
    public Response getStudent(
            @PathParam("id") Long id
    ) {
        var student = studentService.getStudent(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(student).build();
    }
}
