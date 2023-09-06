package com.mvukosav.noteapp.feature_note.domain.use_case

import com.mvukosav.noteapp.feature_note.domain.model.InvalidNoteException
import com.mvukosav.noteapp.feature_note.domain.model.Note
import com.mvukosav.noteapp.feature_note.domain.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("THe title of the not can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("THe content of the not can't be empty")
        }
        noteRepository.insertNote(note)
    }
}