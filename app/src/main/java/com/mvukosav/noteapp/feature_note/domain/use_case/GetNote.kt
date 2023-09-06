package com.mvukosav.noteapp.feature_note.domain.use_case

import com.mvukosav.noteapp.feature_note.domain.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(noteId: Int) = noteRepository.getNoteById(noteId)
}