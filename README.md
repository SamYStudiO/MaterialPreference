MaterialPreference
==================
Android [Material](https://github.com/material-components/material-components-android) version of [Preference](https://developer.android.com/jetpack/androidx/releases/preference) Jetpack library.

This library replace all [platform dialog](https://developer.android.com/reference/android/app/AlertDialog.Builder) with [material dialog](https://github.com/material-components/material-components-android/blob/master/lib/java/com/google/android/material/dialog/MaterialAlertDialogBuilder.java).
It Also add some [preferences](https://developer.android.com/reference/androidx/preference/Preference) as [MaterialSlidePreference]() and other material components...

Note this library is still build on top of [Preference](https://developer.android.com/reference/androidx/preference/Prefere) library and is not a replacement.

Download
--------
YET TO BE RELEASED (WORK IN PROGRESS)


Snapshots are available from [Sonatype's snapshots repository](https://oss.sonatype.org/content/repositories/snapshots/).
If you want to run latest snapshot add its repository from your root `build.gradle`:
```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        ...
        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
    }
}
```
and change versions:
```groovy
implementation 'net.samystudio.materialpreference:materialpreference:0.1-SNAPSHOT'
```

Publishing
-----

 1. Change the version in `gradle.properties` to a non-SNAPSHOT version.
 2. Update the `CHANGELOG.md` for the impending release.
 3. Update the `README.md` with the new version.
 4. `git commit -am "Prepare for release X.Y.Z"` (where X.Y.Z is the new version)
 5. `./gradlew uploadArchives --no-daemon --no-parallel`
 6. `git tag -a X.Y.Z -m "Version X.Y.Z"` (where X.Y.Z is the new version)
 7. Update the `gradle.properties` to the next SNAPSHOT version.
 8. `git commit -am "Prepare next development version"`
 9. `git push && git push --tags`
 10. `./gradlew closeAndReleaseRepository` or visit [Sonatype Nexus](https://oss.sonatype.org/) and promote the artifact.

License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
