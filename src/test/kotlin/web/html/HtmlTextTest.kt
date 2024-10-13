/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlTextTest.kt" file from the KTML project.
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
import org.junit.jupiter.api.Test
import web.html.HtmlText.Companion.html

class HtmlTextTest {

    @Test
    fun replacesAllSpecialCharacters() {

        val element = HtmlText("<script>\n")

        assertEquals("&lt;script&gt;<br>", element.toString())
    }

    @Test
    fun toPrettyStringEqualsToString() {

        val expected = "&lt;lorem&gt; ipsum<br>\n dolor et"

        val element = HtmlText("<lorem> ipsum\n dolor et")

        assertEquals(expected, element.toPrettyString())
    }

    @Test
    fun stringConstructor() {

        val text = "<lorem ipsum>"

        assertEquals(HtmlText(text), text.html())
    }
}