/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlElement.kt" file from the KTML project.
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

import web.WebElement

/**
 * # HtmlElement
 *
 * An HTML element is an object that can be used to create a Hyper Text Markup Language document.
 */
interface HtmlElement : WebElement {

    companion object {

        /**
         * # String.addIndent
         *
         * Adds one level of indentation to the string.
         *
         * Adds a tabulation at the beginning of the string and after every new line character.
         *
         * @return a copy of the string and adds one level of indentation to the string.
         */
        internal fun String.addIndent(): String {

            return this
                .replace("^(.*)".toRegex(), "\t$1")
                .replace("\n", "\n\t")
        }

        /**
         * # List<HtmlElement>.toPrettyString
         *
         * Returns the string representation of the web element with indentation and new lines.
         */
        fun List<HtmlElement>.toPrettyString(): String = joinToString("\n") { it.toPrettyString() }

    }
}