# cal-el [![](https://jitpack.io/v/SpaceBison/cal-el.svg)](https://jitpack.io/#SpaceBison/cal-el)
Cal-El - a superpowered Android calendar widget

# Installation

Add Jitpack repository:


```
maven { url 'https://jitpack.io' }
```

Register dependency; if using Java 8 with `java.time` for API >= 26:

```
implementation('com.github.SpaceBison:cal-el:0.1:javatime@aar') { transitive = true }
```

or if using [a backport](https://github.com/JakeWharton/ThreeTenABP):
```
implementation('com.github.SpaceBison:cal-el:0.1:threeten@aar') { transitive = true }
```