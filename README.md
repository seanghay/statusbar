## Status Bar
A small library for configuring status bar color in Fragment.

## Installation

1. Add JitPack
```groovy
allprojects {
     repositories {
	maven { url 'https://jitpack.io' }
     }
}

```

2. Add dependency
```groovy
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

