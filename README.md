## Status Bar
A small library for configuring status bar color in Fragment.

## Installation

```groovy
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
}

dependencies {
    implementation 'com.github.seanghay:statusbar:1.0.0'
}
```

## Usage

```kotlin
class MyFragment: Fragment() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // A simple extension
        statusBar().color(Color.WHITE).light(true)
    }
}

```

