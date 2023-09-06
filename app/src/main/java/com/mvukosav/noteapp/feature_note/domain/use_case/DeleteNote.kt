package com.mvukosav.noteapp.feature_note.domain.use_case

import com.mvukosav.noteapp.feature_note.domain.model.Note
import com.mvukosav.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.deleteNote(note)
}