![icon.svg](icon.svg)

# KTML

- I - Introduction
- II - Download
- III - Use
- IV - About

---

### I - Introduction

KTML provides the lowest level of abstraction between Kotlin and the foundational web languages of HTML, CSS and
Javascript,
allowing you to create web pages from Kotlin code and to build more complex components.

---

### II - Download

__Gradle__

In `build.gradle` :

```gradle
repositories {
	maven { url 'https://jitpack.io' }
}
```

```gradle
dependencies {
	implementation 'com.github.MaxBuster380:KTML:1.3.1'
}
```

__Gradle (Kotlin)__

In `build.gradle` :

```kt
repositories {
    maven("https://jitpack.io")
}
```

```kt
dependencies {
    implementation("com.github.MaxBuster380:KTML:1.3.1")
}
```

__Maven__

In `pom.xml` :

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
    <groupId>com.github.MaxBuster380</groupId>
    <artifactId>KTML</artifactId>
    <version>1.3.1</version>
</dependency>
```

---

### III - Use

This code :

```kt
fun main() {

    val title = "KTML example"

    val page = HtmlContentTag(
        "html", attributes = hashMapOf("lang" to "en"), content = HtmlList(

            HtmlContentTag(
                "head", content = HtmlList(

                    HtmlObjectTag("meta", attributes = hashMapOf("charset" to "utf-8")),

                    HtmlContentTag(
                        "title", content =
                        title.html()
                    )
                )
            ),

            HtmlStyleTag(
                CssStyle(
                    CssScope(
                        CssScopeTarget("h1"),
                        CssProperties(
                            hashMapOf(
                                "background-image" to "linear-gradient(45deg, #6040E0, #366668)",
                                "background-clip" to "text",
                                "color" to "transparent"
                            )
                        )
                    )
                )
            ),

            HtmlContentTag(
                "body", content = HtmlList(

                    HtmlContentTag(
                        "h1", content =
                        title.html()
                    ),

                    HtmlContentTag(
                        "p", content =
                        """This page was generated using KTML.
                        |<span>This is not interpreted as a tag.</span>""".trimMargin().html()
                    )
                )
            )
        )
    )

    val file = File("./MainKt.html")
    val fileWriter = BufferedWriter(FileWriter(file))

    fileWriter.write(page.toPrettyString())

    fileWriter.flush()
    fileWriter.close()
}
```

gives this :

```html
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>
	        KTML example
	    </title>
	</head>
	<style>
	    h1 {
			background-image:linear-gradient(45deg, #6040E0, #366668);
			background-clip:text;
			color:transparent;
		}
	</style>
	<body>
		<h1>
		    KTML example
		</h1>
		<p>
	   		This page was generated using KTML.<br>
	   		&lt;span&gt;This is not interpreted as a tag.&lt;/span&gt;
		</p>
	</body>
</html>
```

### IV - About

By MaxBuster

[GitHub Repository](https://github.com/MaxBuster380/KTML)