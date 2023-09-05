package com.mvukosav.noteapp.feature_note.domain.use_case

import com.mvukosav.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteById(private val noteRepository: NoteRepository) {

    suspend fun invoke(noteId: Int) = noteRepository.getNoteById(noteId)
}