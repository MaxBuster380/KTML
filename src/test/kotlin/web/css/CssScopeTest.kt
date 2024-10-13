/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "CssScopeTest.kt" file from the KTML project.
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

package web.css

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CssScopeTest {

    @Test
    fun tryToString() {

        val style = CssScope(
            header = CssScopeHeadTarget(".test"),
            properties = CssProperties(hashMapOf("display" to "flex", "flex-direction" to "column")),
            subScopes = mutableSetOf(
                CssScope(
                    header = CssScopeHeadTarget(".sub-test1"),
                    properties = CssProperties(hashMapOf("width" to "100%"))
                ), CssScope(
                    header = CssScopeHeadTarget(".sub-test2"),
                    properties = CssProperties(hashMapOf("height" to "54px"))
                )
            )
        )

        assertEquals(
            ".test{display:flex;flex-direction:column;.sub-test1{width:100%;}.sub-test2{height:54px;}}",
            style.toString()
        )
    }

    @Test
    fun toPrettyString() {

        val style = CssScope(
            header = CssScopeHeadTarget(".test"),
            properties = CssProperties(hashMapOf("display" to "flex", "flex-direction" to "column")),
            subScopes = mutableSetOf(
                CssScope(
                    header = CssScopeHeadTarget(".sub-test1"),
                    properties = CssProperties(hashMapOf("width" to "100%"))
                ), CssScope(
                    header = CssScopeHeadTarget(".sub-test2"),
                    properties = CssProperties(hashMapOf("height" to "54px"))
                )
            )
        )

        assertEquals(
            ".test {\n\tdisplay:flex;\n\tflex-direction:column;\n\t\n\t.sub-test1 {\n\t\twidth:100%;\n\t}\n\t\n\t.sub-test2 {\n\t\theight:54px;\n\t}\n}",
            style.toPrettyString()
        )
    }
}