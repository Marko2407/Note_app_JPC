package com.mvukosav.noteapp.di

import android.app.Application
import androidx.room.Room
import com.mvukosav.noteapp.feature_note.data.data_source.NoteDao
import com.mvukosav.noteapp.feature_note.data.data_source.NoteDatabase
import com.mvukosav.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.mvukosav.noteapp.feature_note.domain.repository.NoteRepository
import com.mvukosav.noteapp.feature_note.domain.use_case.AddNote
import com.mvukosav.noteapp.feature_note.domain.use_case.DeleteNote
import com.mvukosav.noteapp.feature_note.domain.use_case.GetNote
import com.mvukosav.noteapp.feature_note.domain.use_case.GetNotes
import com.mvukosav.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNodeDatabase(application: Application): NoteDatabase =
        Room.databaseBuilder(application, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository = NoteRepositoryImpl(db.noteDao)


    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases = NoteUseCases(
        getNotes = GetNotes(repository),
        deleteNote = DeleteNote(repository),
        addNote = AddNote(repository),
        getNote = GetNote(repository)
    )
}