# Status Downloader (Flutter + Android SAF)

This repository contains a Flutter app with Android-native SAF helpers:
- Pick a folder using SAF (Storage Access Framework)
- List and preview files (images, gifs, videos)
- Save selected or all statuses into `Pictures/WhatsAppStatusDownloader`
- In-app preview (ExoPlayer) and thumbnail caching

---

## Quick start (from Android phone)

### 1. Extract project
- Unzip the released project on your phone, keep the folder structure.

### 2. Build locally on phone (optional)
- Install Termux and Flutter (advanced) — building Flutter on phone is heavy. Easier: use cloud CI (Codemagic or GitHub Actions).

### 3. Build on GitHub Actions (recommended)
- Add required repo secrets (Settings → Secrets → Actions):
  - `KEYSTORE_BASE64` — base64 of your `my-release-key.jks` (if you want CI to sign)
  - `KEYSTORE_PASSWORD`
  - `KEY_ALIAS`
  - `KEY_PASSWORD`
- Push to `main` / `master` and the workflow `.github/workflows/flutter-build-signed.yml` will run and produce an APK artifact.

### 4. Build on Codemagic
- Sign in to Codemagic, connect repo, upload keystore in UI, set environment variables for the passwords/alias, and run the workflow.

---

## Generate keystore on phone (Termux)
```bash
pkg update
pkg install openjdk-17
keytool -genkey -v -keystore my-release-key.jks -alias my-key-alias \
  -keyalg RSA -keysize 2048 -validity 10000
# base64 encode for CI
base64 my-release-key.jks > my-release-key.jks.base64
