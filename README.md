<div align="center">

  <img src="assets/Echo-new.png" alt="IRAH Music Logo" width="130" style="border-radius: 28px;"/>

  # IRAH Music 🎵

  **A modern, personalized, ad-free Android music streaming experience powered by IRAH & crafted for Harinath.**

  [![License: GPL-3.0](https://img.shields.io/badge/License-GPL--3.0-blue.svg?style=for-the-badge)](LICENSE)
  [![Platform](https://img.shields.io/badge/Platform-Android%208.0%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://android.com)
  [![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
  [![Gradle](https://img.shields.io/badge/Gradle-9.5-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org)
  [![Status](https://img.shields.io/badge/Edition-Custom%20Personalized%20Build-FF4081?style=for-the-badge)](https://github.com/harinath4496/IrahMusic)

  <br>

  <p align="center">
    <b>IRAH Music</b> brings seamless audio streaming, real-time word-by-word synchronized lyrics, AI-momentum recommendations via <i>IRAH Brain</i>, lossless local playback, and a fluid Material 3 Expressive UI to your pocket — with zero ads and zero distractions.
  </p>

</div>

---

## 🌟 Lineage, Open-Source Ethics & Attribution

> **Honest Open-Source Attribution**:
> **IRAH Music** is an enhanced, personalized edition customized and curated by **Harinath** and powered by **IRAH**. 
>
> This project is proudly built upon the foundational work of **[Echo Music](https://github.com/EchoMusicApp/Echo-Music)** (created by [Aditya Yadav](https://github.com/iad1tya) and its open-source contributors) and the **[InnerTube](https://github.com/MetrolistGroup/Metrolist)** ecosystem.
>
> We believe in genuine open-source ethics:
> - Full compliance with the **GNU General Public License v3.0 (GPL-3.0)**.
> - Preserving and honoring all upstream licenses, contributor credits, and original author links.
> - Transparency: This fork introduces custom personalization ("Crafted for Harinath"), fine-tuned build configurations, UI styling adaptations, and wireless ADB deployment integration.
> 
> *Thank you to Aditya Yadav, Metrolist, SimpMusic, and the open-source Android community for creating the building blocks that made this project possible.*

---

## 📸 Interface Preview

<div align="center">
  <table>
    <tr>
      <td align="center" width="33%">
        <b>Home Screen</b><br><br>
        <img src="Screenshots/Home.png" alt="Home Screen" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
      <td align="center" width="33%">
        <b>Material You Player</b><br><br>
        <img src="Screenshots/Material%20you%20music%20page.png" alt="Material Player" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
      <td align="center" width="33%">
        <b>Apple-Inspired Player</b><br><br>
        <img src="Screenshots/Apple%20inspired%20music%20page.png" alt="Apple Style Player" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
    </tr>
    <tr>
      <td align="center" width="33%">
        <b>Synchronized Lyrics</b><br><br>
        <img src="Screenshots/lyrics.png" alt="Synchronized Lyrics" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
      <td align="center" width="33%">
        <b>Library & Playlists</b><br><br>
        <img src="Screenshots/library.png" alt="Library" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
      <td align="center" width="33%">
        <b>Search & Discovery</b><br><br>
        <img src="Screenshots/search%20page.png" alt="Search Page" width="220" style="border-radius: 14px; box-shadow: 0 8px 24px rgba(0,0,0,0.25);"/>
      </td>
    </tr>
  </table>
</div>

---

## ✨ Key Features

### 🎧 Pure, Ad-Free Music Streaming
- **Unlimited YouTube Music Catalog**: Stream official tracks, albums, remixes, live performances, and community audio without commercials or forced interruptions.
- **Audio Quality Optimization**: Adaptive streaming up to 256kbps Opus/AAC for crystal-clear clarity on mobile networks or Wi-Fi.
- **Background & Lock Screen Playback**: Seamless audio playback with complete notification controls and lock screen art.

### 🧠 IRAH Brain (Intelligent On-Device Queueing)
- **Momentum Engine**: Analyzes your real-time listening vibe and automatically cues songs that naturally fit your musical flow.
- **Zero Privacy Invasions**: Operates entirely on-device without telemetry or sending your private habits to third-party ad networks.

### 🎤 Synchronized & Word-by-Word Lyrics
- **Multi-Source Fetcher**: Lyrics are fetched from **LrcLib**, **KuGou**, **Musixmatch**, and **BetterLyrics** with intelligent automatic fallback.
- **Live Karaoke Animations**: Fluid word-level sync and smooth auto-scrolling with multiple animation styles.

### 🔄 Spotify Fast Sync
- **1-Tap Import**: Bring your favorite Spotify playlists into IRAH Music in seconds.
- **Fast Sync**: Keep local playlists up-to-date with your latest Spotify discoveries effortlessly.

### 💽 Offline Playback & Local FLAC Support
- **Offline Storage**: Save songs and playlists locally with cached artwork and metadata.
- **Local Audio Player**: Play your device's native FLAC, MP3, WAV, and M4A files with high-fidelity equalizer presets (including *IRAH Signature EQ*).

### 🎨 Material 3 Expressive & AMOLED Design
- **Multiple Player Layouts**: Switch between dynamic Material You dynamic-color styles and Apple-inspired blur aesthetic.
- **Deep Black AMOLED Theme**: Optimized for battery saving and stunning contrast on modern OLED displays.
- **Live Canvas Animations**: Dynamic looping visuals and artist videos during playback.

---

## 🏗️ Technical Architecture & Stack

IRAH Music is engineered with modern Android best practices:

```
IrahMusic/
├── app/                  # Main presentation, Compose UI, ViewModels, Hilt modules
├── core/                 # Shared data models, Room database, preferences, base utils
├── playback/             # AndroidX Media3 (ExoPlayer), audio service, caching pipeline
├── innertube/            # YouTube Music & InnerTube API client, response parsers
├── lyrics/               # Unified lyric resolution engine (LrcLib, KuGou, BetterLyrics)
├── artistvideo/          # Background artist video & canvas fetching
├── unison/               # Real-time multi-device sync engine (Listen Together)
└── shazamkit/            # Audio fingerprinting & music recognition module
```

### Core Technologies
- **Language**: Kotlin 2.1.0 with Coroutines & StateFlow.
- **UI Framework**: 100% Jetpack Compose with Material 3 Design System.
- **Dependency Injection**: Dagger Hilt for modular, testable architecture.
- **Media Engine**: AndroidX Media3 (ExoPlayer) with custom audio effect filters and equalizer.
- **Local Database**: Room DB for lightning-fast offline indexing.
- **Network Stack**: Ktor & OkHttp with Kotlinx Serialization.

---

## 🚀 Building from Source

### Prerequisites
1. **JDK 21** (e.g. JetBrains Runtime or OpenJDK 21)
2. **Android SDK** (API Level 35+, Build Tools 35.0.0+)
3. **Gradle 9.5+** (managed via the included `./gradlew` wrapper)

### Setup Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/harinath4496/IrahMusic.git
   cd IrahMusic
   ```

2. **Configure SDK Location**
   Create a `local.properties` file in the root directory:
   ```properties
   # On Windows
   sdk.dir=C\:\\Users\\<YourUsername>\\AppData\\Local\\Android\\Sdk

   # On Linux / macOS
   sdk.dir=/home/<username>/Android/Sdk
   ```

3. **Assemble the APK**
   Build the optimized ARM64 variant (recommended for modern Android devices):
   ```bash
   # On Linux/macOS
   ./gradlew assembleArm64GmsDebug

   # On Windows
   gradlew.bat assembleArm64GmsDebug
   ```

   The generated APK will be available at:
   `app/build/outputs/apk/arm64Gms/debug/app-arm64-gms-debug.apk`

---

## 📲 Wireless ADB Deployment Guide

IRAH Music can be directly deployed to your phone over Wi-Fi using Android's **Wireless Debugging**:

1. **Enable Wireless Debugging**:
   - Go to `Settings -> Additional settings -> Developer options`.
   - Enable **Wireless debugging** and ensure **Install via USB** is toggled ON (for Xiaomi / HyperOS / MIUI devices).
   - Tap *Wireless debugging* to view your device's **IP address and port** (e.g. `192.168.1.100:33123`).

2. **Connect ADB over Wi-Fi**:
   ```bash
   adb connect <device-ip>:<port>
   adb devices
   ```

3. **Install & Launch Directly**:
   ```bash
   adb install -r app/build/outputs/apk/arm64Gms/debug/app-arm64-gms-debug.apk
   adb shell monkey -p echo.music.iad1tya.debug -c android.intent.category.LAUNCHER 1
   ```

---

## 🤝 Upstream Credits & Acknowledgments

This project would not be possible without the incredible work done by the open-source community:

| Project / Contributor | Description |
| :--- | :--- |
| **[Echo Music](https://github.com/EchoMusicApp/Echo-Music)** by **Aditya Yadav** | The upstream open-source music player providing the foundation for IRAH Music |
| **[Metrolist](https://github.com/MetrolistGroup/Metrolist)** | Foundational architecture and InnerTube integration reference |
| **[Vivi Music](https://github.com/vivizzz007/vivi-music)** | Architecture and client implementation concepts |
| **[Better Lyrics](https://better-lyrics.boidu.dev/)** | Synchronized lyrics engine and formatting |
| **[SimpMusic](https://github.com/maxrave-dev/SimpMusic)** | Synchronized lyric parsing references |
| **[ArchiveTune](https://github.com/koiverse/ArchiveTune)** | Material You expressive UI patterns |
| **[BravePipe](https://github.com/bravepipeproject/BravePipe)** | Media decryption and stream resolution |

---

## ⚖️ Legal Disclaimer

- **100% Free & Non-Commercial**: IRAH Music is an open-source project created strictly for educational, personal, and research purposes. It contains no monetization, advertisements, premium upgrades, or paid tiers.
- **No Media Hosting**: IRAH Music does not host, store, or distribute any media files. It functions as a lightweight client parsing public streaming links from Google / YouTube servers.
- **Support Artists**: We strongly encourage users to support their favorite artists by purchasing music and subscribing to official services like [YouTube Premium](https://www.youtube.com/premium) and [Spotify](https://spotify.com).

---

<div align="center">
  <p><b>Crafted with ❤️ by Harinath & IRAH</b></p>
  <p>Licensed under <a href="LICENSE">GNU General Public License v3.0</a></p>
</div>
