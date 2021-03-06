# Status Bar

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![Build Status](https://jitpack.io/v/seanghay/statusbar.svg)

A small library for configuring status bar color in Fragment.

It can be useful in Navigation Component where we have only one Activity but many Fragments.

#### Try it and give us feedback! :smiley:

## Usage in Kotlin Only

```kotlin
class MyFragment: Fragment() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // A simple extension
        statusBar.color(Color.WHITE).light(true)
    }
}

```

## Usage in Java
```java
public class MyFragment extends Fragment {
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
        StatusBar.with(this)
		.color(Color.WHITE)
		.light(true);
    }
}

```


## Installation

1. Add JitPack
```gradle
allprojects {
     repositories {
	maven { url 'https://jitpack.io' }
     }
}

```

2. Add dependency
```gradle
dependencies {
    implementation 'com.github.seanghay:statusbar:1.0.1'
}
```

## License
Copyright 2019 Seanghay Yath

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

