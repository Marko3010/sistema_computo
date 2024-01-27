package com.computo.controller;

import com.computo.dto.CommentDTO;
import com.computo.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/comentario")
public class CommentController {


    private final CommentService service;


    @PostMapping("/producto/{id}/comentario")
    public ResponseEntity<CommentDTO> crearComentario(@Valid @PathVariable(value = "id") Long productId, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(service.createComment(productId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/producto/{productoId}/comentarios")
    public ResponseEntity<List<CommentDTO>> listarComentarioPorProductoId(@PathVariable (value = "productoId") Long productoId){
        return new ResponseEntity<>(service.obtenerComentarioPorId(productoId), HttpStatus.OK);

    }

    @GetMapping("/producto/{productoId}/comentario/{id}")
    public ResponseEntity<CommentDTO> obtenerComentarioYProductoId(@PathVariable (value = "productoId") Long productoId, @PathVariable (value = "id") Long comentarioId){

        CommentDTO commentDTO = service.obtenerComentarioYProductoId(productoId, comentarioId);

        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/producto/{productoId}/actualizar/{id}")
    public ResponseEntity<CommentDTO> actualizarComentario(@PathVariable (value = "productoId") Long pructoId, @PathVariable(value = "id") Long comentarioId,
                                                           @Valid @RequestBody CommentDTO commentDTO){

        CommentDTO comentarioActualizado = service.actualizarComentario(pructoId, comentarioId, commentDTO);

        return new ResponseEntity<>(comentarioActualizado,HttpStatus.OK);
            }

    @DeleteMapping("/producto/{productoId}/borrar/{id}")
    public ResponseEntity<String> eliminarComentario (@PathVariable(value = "productoId") Long productoId, @PathVariable(value = "id") Long comentarioId){
      service.eliminarComentario(productoId, comentarioId);
      log.info("ejucutando borrado de elemento");

      return new ResponseEntity<>("comentario borrado con exito", HttpStatus.OK);
    }



    }




