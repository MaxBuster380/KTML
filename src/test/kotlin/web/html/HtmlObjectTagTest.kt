/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlObjectTagTest.kt" file from the KTML project.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package web.html

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import web.css.CssProperties
import web.html.tags.HtmlObjectTag
import kotlin.test.assertFails

class HtmlObjectTagTest {

    private val singleDiv = HtmlObjectTag(name = "div")
    private val singleImg = HtmlObjectTag(name = "img")
    private val indexedDiv = HtmlObjectTag(name = "div", id = "myId")
    private val singleClassDiv = HtmlObjectTag(name = "div", classes = mutableSetOf("myClass"))
    private val multiClassDiv = HtmlObjectTag(name = "div", classes = mutableSetOf("myFirstClass", "mySecondClass"))
    private val multiClassIndexedDiv =
        HtmlObjectTag(name = "div", id = "myId", classes = mutableSetOf("myFirstClass", "mySecondClass"))
    private val propertiedDiv = HtmlObjectTag(name = "div", attributes = hashMapOf("foo" to "bar", "bar" to "foo"))
    private val styledDiv =
        HtmlObjectTag(name = "div", style = CssProperties(hashMapOf("display" to "flex", "flex-direction" to "column")))

    @Test
    fun testToString() {

        assertEquals("<div>", singleDiv.toString())
        assertEquals("<img>", singleImg.toString())
        assertEquals("<div id=\"myId\">", indexedDiv.toString())
        assertEquals("<div class=\"myClass\">", singleClassDiv.toString())
        assertEquals("<div class=\"myFirstClass,mySecondClass\">", multiClassDiv.toString())
        assertEquals("<div id=\"myId\" class=\"myFirstClass,mySecondClass\">", multiClassIndexedDiv.toString())
        assertEquals("<div bar=\"foo\" foo=\"bar\">", propertiedDiv.toString())
        assertEquals("<div style=\"display: flex;flex-direction: column;\">", styledDiv.toString())
    }

    @Test
    fun prettyStringEqualsToString() {

        val elements = listOf(
            singleDiv,
            singleImg,
            indexedDiv,
            singleClassDiv,
            multiClassDiv,
            multiClassIndexedDiv,
            propertiedDiv,
            styledDiv
        )

        for (element in elements)
            assertEquals(element.toString(), element.toPrettyString())
    }

    @Test
    fun reservedProperties() {

        assertFails {
            HtmlObjectTag(name = "div", attributes = hashMapOf("id" to "myId"))
        }

        assertFails {
            HtmlObjectTag(name = "div", attributes = hashMapOf("style" to "myStyle"))
        }

        assertFails {
            HtmlObjectTag(name = "div", attributes = hashMapOf("class" to "myClasses"))
        }

        val element = HtmlObjectTag(name = "div")

        assertFails {
            element["id"] = "myId"
        }

        assertFails {
            element["class"] = "myClass"
        }

        assertFails {
            element["style"] = "myStyle"
        }
    }

    @Test
    fun unsetProperty() {

        val propertyName = "property"

        val element = HtmlObjectTag(name = "div", attributes = hashMapOf(propertyName to "value"))

        element[propertyName]

        element.unsetProperty(propertyName)

        assertNull(element[propertyName])
    }

    @Test
    fun getSetName() {

        val element = HtmlObjectTag(name = "div")

        assertEquals("div", element.name)

        element.name = "test"

        assertEquals("test", element.name)

        assertFails {
            element.name = "script"
        }

        assertFails {
            element.name = "style"
        }
    }
}