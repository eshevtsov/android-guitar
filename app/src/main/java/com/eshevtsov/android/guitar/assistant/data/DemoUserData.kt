package com.eshevtsov.android.guitar.assistant.data

import com.eshevtsov.android.guitar.assistant.database.entity.AlbumEntity
import com.eshevtsov.android.guitar.assistant.database.entity.ArtistEntity
import com.eshevtsov.android.guitar.assistant.database.entity.LinkEntity
import com.eshevtsov.android.guitar.assistant.database.entity.SongEntity

object DemoUserData {

    val ARTIST_LIST = listOf(DemoArtist.LP, DemoArtist.BTS)

    val ALBUM_LIST = listOf(
        DemoAlbum.LP_METEORA,
        DemoAlbum.LP_ONE_MORE_LIGHT,
        DemoAlbum.BTS_MIC_DROP
    )

    val LINK_LIST = listOf(
        DemoLink.BTS_FACEBOOK,
        DemoLink.BTS_INSTAGRAM,
        DemoLink.LP_FACEBOOK,
        DemoLink.LP_INSTAGRAM,
        DemoLink.LP_TWITTER,
        DemoLink.LP_YOUTUBE
    )

    val SONG_LIST = listOf(
        DemoSong.BTS_MIC_DROP,
        DemoSong.LP_NUMB,
        DemoSong.LP_FAINT,
        DemoSong.LP_BREAKING_THE_HABIT,
        DemoSong.LP_TALKING_TO_MYSELF
    )
}

private object DemoArtist {
    val LP = ArtistEntity(
        id = 1L,
        name = "Linkin Park",
        imageUri = "https://i.imgur.com/7z6d0Ei.jpg"
    )
    val BTS = ArtistEntity(
        id = 2L,
        name = "BTS",
        imageUri = "https://i.imgur.com/g6ijvlB.jpg"
    )
}

private object DemoLink {
    val BTS_FACEBOOK = LinkEntity(
        id = 1L,
        artistForeignId = DemoArtist.BTS.id,
        value = "https://www.facebook.com/bangtan.official",
        type = LinkEntity.Type.Facebook
    )
    val BTS_INSTAGRAM = LinkEntity(
        id = 2L,
        artistForeignId = DemoArtist.BTS.id,
        value = "https://www.instagram.com/bts.bighitofficial/",
        type = LinkEntity.Type.Instagram
    )
    val LP_INSTAGRAM = LinkEntity(
        id = 3L,
        artistForeignId = DemoArtist.LP.id,
        value = "https://www.facebook.com/linkinpark/",
        type = LinkEntity.Type.Facebook
    )
    val LP_FACEBOOK = LinkEntity(
        id = 4L,
        artistForeignId = DemoArtist.LP.id,
        value = "https://www.instagram.com/linkinpark/",
        type = LinkEntity.Type.Instagram
    )
    val LP_TWITTER = LinkEntity(
        id = 5L,
        artistForeignId = DemoArtist.LP.id,
        value = "https://twitter.com/linkinpark",
        type = LinkEntity.Type.Twitter
    )
    val LP_YOUTUBE = LinkEntity(
        id = 6L,
        artistForeignId = DemoArtist.LP.id,
        value = "https://www.youtube.com/channel/UCZU9T1ceaOgwfLRq7OKFU4Q?sub_confirmation=1",
        type = LinkEntity.Type.Youtube
    )
}

private object DemoAlbum {
    val LP_METEORA = AlbumEntity(
        id = 1L,
        artistForeignId = DemoArtist.LP.id,
        name = "Meteora",
        year = 2003,
        coverUri = "https://i.imgur.com/18KkDfX.jpg"
    )

    val LP_ONE_MORE_LIGHT = AlbumEntity(
        id = 2L,
        artistForeignId = DemoArtist.LP.id,
        name = "One More Light",
        year = 2017,
        coverUri = "https://i.imgur.com/gMlIOmH.jpg"
    )

    val BTS_MIC_DROP = AlbumEntity(
        id = 3L,
        artistForeignId = DemoArtist.BTS.id,
        name = "MIC Drop (feat. Desiigner) [Steve Aoki Remix] - Single",
        genre = AlbumEntity.Genre.KPop,
        year = 2017,
        coverUri = "https://i.imgur.com/JKH0KAG.jpg"
    )
}

private object DemoSong {
    val BTS_MIC_DROP = SongEntity(
        id = 1L,
        albumForeignId = DemoAlbum.BTS_MIC_DROP.id,
        name = "MIC Drop (feat. Desiigner) [Steve Aoki Remix]",
        timeMilliseconds = 214800,
        numberInAlbum = 1,
        text = """
            [Intro: Desiigner]
            Git, git, brrra, git, git
            (Damn, son, where'd you get that from?)
            Git, git, hey, brrra
            Damn, hey, brrra
            Git, git (Damn, bro)

            [Verse 1: Desiigner]
            Bentley basketball, uh (Git)
            We playin' that a lot, huh
            I'ma just get to the chicken, whip it (Git, yuh)
            Then I flip it, then trap it all, huh (Git, git, brrra, trap it all)
            I gotta get to the dolla
            ...on the haters and back 'em off (Git, git, brrra, back)
            Smokin' on gas a lot, ready to wack 'em all
            Huh, huh, wack 'em all, wack 'em all (Brrr, brrr, wack)
            Clap, clap, clap, clap, clap 'em all, huh
            This what I do to the haters
            The choppa hit 'em, tell 'em back 'em off, huh
            She like Apple Jack, huh (Git, Jack)
            I like apple sauce, huh, huh (Brrra)
            That's a boss, huh, huh (Boss, git, git)
            That's the cost, huh, huh (Cost, brrra, git, git)
            Why you tryna flex and your fashion off? (Brrra, flex)
            Chain around my neck and her ass soft (Ayy)
            Smokin' on that gas, I ain't passin' off (Git, git, smoke)
            Asthma cough (Asthma), fashion law (Flexin')
            Stash it off (Brrra, stash, stash), dash in' off (Dash)
            Flash it off (Brrra, flash), don't pass it off (Hey, hey)
            I'ma just get to the chicken and trap hard, hard, hard with all my
            [Pre-Chorus: V, Jungkook, Jimin, Jin]
            Did you see my bag? (Where?)
            Did you see my bag? (Where?)
            It's hella trophies and it's hella thick (Hella thick, hella thick)
            What you think 'bout that? (Well)
            What you think 'bout that? (Well)
            I bet it got my haters hella sick (Hella sick)
            Come and follow me, follow me with your signs up (Uh)
            I'm so firin', firin', boy, your time's up (Uh)
            Keep on runnin' and runnin' until I catch up (Uh)
            How you dare? How you dare? How you dare? (Dare, ah)

            [Chorus: Jungkook, RM & Suga, Jimin, RM & J-Hope]
            Another trophy, my hands carry 'em (Hey)
            Too many that I can't even count 'em (Turn it up now)
            Mic drop, mic drop
            발, 발 조심, 너네 말, 말조심
            Somebody stop me, I'm 'bout to pop off (Pop)
            Too busy, you know my body ain't enough (Turn it up now)Mic drop, mic drop
            발, 발 조심, 너네 말, 말조심

            [Verse 2: Suga, J-Hope, RM & Desiigner]
            Baby, watch your mouth (Mouth)
            It come back around ('round)
            Once upon a time (Time)
            We learned how to fly (Fly)
            Go look at your mirror (Ooh)
            Same damn clothes (Git)
            You know how I feel (Ooh)
            개행복 (Turn up)
            How many hours do we fly? (Ooh)
            I keep on dreamin' on the cloud (Hah)
            Yeah, I'm on the mountain, yeah, I'm on the bay (Pop)
            Everyday we vibin', mic drop, bam
            [Pre-Chorus: Jungkook, V, Jimin & Jin]
            Did you see my bag? (Where?)
            Did you see my bag? (Where?)
            It's hella trophies and it's hella thick (Hella thick, hella thick)
            What you think 'bout that? (Well)
            What you think 'bout that? (Well)
            I bet it got my haters hella sick (Hella sick)
            Come and follow me, follow me with your signs up (Uh)
            I'm so firin', firin', boy, your time's up (Uh)
            Keep on runnin' and runnin' until I catch up (Uh)
            How you dare? How you dare? How you dare? (Dare, ah)

            [Chorus: Jungkook, RM & Suga, Jimin, RM & J-Hope]
            Another trophy, my hands carry 'em (Hey)
            Too many that I can't even count 'em (Turn it up now)
            Mic drop, mic drop
            발, 발 조심, 너네 말, 말조심
            Somebody stop me, I'm 'bout to pop off (Pop)
            Too busy, you know my body ain't enough (Turn it up now)Mic drop, mic drop
            발, 발 조심, 너네 말, 말조심

            [Bridge: RM]
            Haters gon' hate
            Players gon' play
            Live a life, man
            Yah, good luck
            [Outro: Jin, V, Jungkook, Jimin, Jungkook & Jimin]
            더 볼 일 없어, 마지막 인사야
            할 말도 없어, 사과도 하지 마
            더 볼 일 없어, 마지막 인사야
            할 말도 없어, 사과도 하지 마
            잘 봐, 넌 그 꼴 나지
            우린 탁 쏴, 마치 콜라지
            너의 각막, 깜짝 놀라지
            꽤, 꽤 폼 나지, 포, 포, 폼 나지, yeah
        """.trimIndent()
    )

    val LP_NUMB = SongEntity(
        id = 2L,
        albumForeignId = DemoAlbum.LP_METEORA.id,
        name = "Numb",
        timeMilliseconds = 184200,
        numberInAlbum = 13,
        text = """
            [Verse 1: Chester Bennington]
            I'm tired of being what you want me to be
            Feeling so faithless, lost under the surface
            I don't know what you're expecting of me
            Put under the pressure of walking in your shoes

            [Pre-Chorus: Chester Bennington & Mike Shinoda]
            Caught in the undertow, just caught in the undertow
            Every step that I take is another mistake to you
            Caught in the undertow, just caught in the undertow

            [Chorus: Chester Bennington]
            I've become so numb, I can't feel you there
            Become so tired, so much more aware
            I'm becoming this, all I want to do
            Is be more like me and be less like you

            [Verse 2: Chester Bennington]
            Can't you see that you're smothering me?
            Holding too tightly, afraid to lose control
            'Cause everything that you thought I would be
            Has fallen apart, right in front of you

            [Pre-Chorus: Chester Bennington & Mike Shinoda]
            Caught in the undertow, just caught in the undertow
            Every step that I take is another mistake to you
            Caught in the undertow, just caught in the undertow
            And every second I waste is more than I can take
            [Chorus: Chester Bennington]
            I've become so numb, I can't feel you there
            Become so tired, so much more aware
            I'm becoming this, all I want to do
            Is be more like me and be less like you

            [Bridge: Chester Bennington]
            And I know I may end up failing, too
            But I know you were just like me
            With someone disappointed in you

            [Chorus: Chester Bennington]
            I've become so numb, I can't feel you there
            Become so tired, so much more aware
            I'm becoming this, all I want to do
            Is be more like me and be less like you

            [Outro: Chester Bennington]
            I've become so numb, I can't feel you there
            I'm tired of being what you want me to be
            I've become so numb, I can't feel you there
            I'm tired of being what you want me to be
        """.trimIndent()
    )

    val LP_FAINT = SongEntity(
        id = 3L,
        albumForeignId = DemoAlbum.LP_METEORA.id,
        name = "Faint",
        timeMilliseconds = 145200,
        numberInAlbum = 7,
        text = """
            [Verse 1: Mike Shinoda]
            I am a little bit of loneliness
            A little bit of disregard
            Handful of complaints, but I can't help the fact
            That everyone can see these scars

            I am what I want you to want
            What I want you to feel
            But, it's like no matter what I do
            I can't convince you to just believe this is real

            [Pre-Chorus: Mike Shinoda]
            So, I let go, watching you
            Turn your back like you always do
            Face away and pretend that I'm not
            But, I'll be here 'cause you're all that I got

            [Chorus: Chester Bennington & both]
            I can't feel the way I did, before
            Don't turn your back on me, I won't be ignored
            Time won't heal this damage, anymore
            Don't turn your back on me, I won't be ignored

            [Verse 2: Mike Shinoda]
            I am a little bit insecure
            A little unconfident
            'Cause you don't understand, I do what I can
            But sometimes, I don't make sense
            I am what you never wanna say
            But, I've never had a doubt
            It's like no matter what I do, I can't convince you
            For once, just to hear me out

            [Pre-Chorus: Mike Shinoda]
            So, I let go, watching you
            Turn your back like you always do
            Face away and pretend that I'm not
            But, I'll be here 'cause you're all that I've got

            [Chorus: Chester Bennington & both]
            I can't feel the way I did, before
            Don't turn your back on me, I won't be ignored
            Time won't heal this damage, anymore
            Don't turn your back on me, I won't be ignored

            [Bridge: Chester Bennington]
            No, hear me out, now
            You're gonna listen to me, like it or not
            Right now, hear me out, now
            You're gonna listen to me, like it or not
            Right now

            I can't feel the way I did before
            Don't turn your back on me, I won't be ignored
            [Chorus: Chester Bennington & both]
            I can't feel the way I did, before
            Don't turn your back on me, I won't be ignored
            Time won't heal this damage, anymore
            Don't turn your back on me, I won't be ignored

            [Outro: Chester Bennington & both]
            I can't feel
            Don't turn your back on me, I won't be ignored
            Time won't heal
            Don't turn your back on me, I won't be ignored
        """.trimIndent()
    )

    val LP_BREAKING_THE_HABIT = SongEntity(
        id = 4L,
        albumForeignId = DemoAlbum.LP_METEORA.id,
        name = "Breaking the habit",
        timeMilliseconds = 189600,
        numberInAlbum = 9,
        text = """
            [Verse 1]
            Memories consume, like opening the wound
            I'm picking me apart again
            You all assume I'm safe here in my room
            Unless I try to start again

            [Pre-Chorus]
            I don't want to be the one the battles always choose
            'Cause inside, I realize that I'm the one confused

            [Chorus]
            I don't know what's worth fighting for or why I have to scream
            I don't know why I instigate and say what I don't mean
            I don't know how I got this way, I know it's not alright
            So, I'm breaking the habit
            I'm breaking the habit tonight

            [Verse 2]
            Clutching my cure, I tightly lock the door
            I try to catch my breath again
            I hurt much more than anytime before
            I had no options left again

            [Pre-Chorus]
            I don't want to be the one the battles always choose
            'Cause inside, I realize that I'm the one confused
            [Chorus]
            I don't know what's worth fighting for or why I have to scream
            I don't know why I instigate and say what I don't mean
            I don't know how I got this way, I'll never be alright
            So, I'm breaking the habit
            I'm breaking the habit tonight

            [Bridge]
            I'll paint it on the walls 'cause I'm the one at fault
            I'll never fight again and this is how it ends

            [Chorus]
            I don't know what's worth fighting for or why I have to scream
            But now I have some clarity to show you what I mean
            I don't know how I got this way, I'll never be alright
            So, I'm breaking the habit
            I'm breaking the habit
            I’m breaking the habit tonight
        """.trimIndent()
    )

    val LP_TALKING_TO_MYSELF = SongEntity(
        id = 5L,
        albumForeignId = DemoAlbum.LP_ONE_MORE_LIGHT.id,
        name = "Talking to Myself",
        timeMilliseconds = 210600,
        numberInAlbum = 3,
        text = """
            [Verse 1]
            Tell me what I've gotta do
            There's no getting through to you
            The lights are on but nobody's home (nobody's home)
            You say I can't understand
            But you're not giving me a chance
            When you leave me, where do you go? (Where do you go?)

            [Pre-Chorus]
            All the walls that you keep building
            All this time that I spent chasing
            All the ways that I keep losing you

            [Chorus]
            The truth is, you turn into someone else
            You keep running like the sky is falling
            I can whisper, I can yell
            But I know, yeah I know, yeah I know
            I'm just talking to myself
            Talking to myself
            Talking to myself
            But I know, yeah I know, yeah I know
            I'm just talking to myself

            [Verse 2]
            I admit I made mistakes
            But yours might cost you everything
            Can't you hear me calling you home?
            [Pre-Chorus]
            Oh, all the walls that you keep building
            All this time that I spent chasing
            All the ways that I keep losing you

            [Chorus]
            The truth is, you turned into someone else
            You keep running like the sky is falling
            I can whisper, I can yell
            But I know, yeah I know, yeah I know
            I'm just talking to myself
            Talking to myself
            Talking to myself
            Yeah I know, yeah I know, yeah I know
            I'm just talking to myself

            [Pre-Chorus]
            All the walls that you keep building
            All this time that I spent chasing
            All the ways that I keep losing you

            [Chorus/Outro]
            The truth is, you turned into someone else
            You keep running like the sky is falling
            I can whisper, I can yell
            But I know, yeah I know, yeah I know
            I'm just talking to myself
            Talking to myself
            Talking to myself
            Yeah I know, yeah I know, yeah I know
            Talking to myself
        """.trimIndent()
    )
}