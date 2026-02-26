package com.example.magnifier_subway.di
// 외부 라이브러리 설정 어떻게 가져올것인가.
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {  //Hilt가 FirebaseAuth가 필요하다하면 갖다줘.
    @Provides  //외부 Firebase가져오는거니까 @Provides 활용
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()  //getInstance를 활용한 물 공구ㅡㅂ
}