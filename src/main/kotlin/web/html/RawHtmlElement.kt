/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "RawHtmlElement.kt" file from the KTML project.
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

/**
 * # RawHtmlElement
 *
 * A raw HTML element wraps an HTML text to be used as an HTML element.
 *
 * **This element must be used with care, as it doesn't filter out any potentially malicious components.
 */
data class RawHtmlElement(
    /**
     * # RawHtmlElement.value
     *
     * The un-sanitized textual value.
     */
    val value: String,
) : HtmlElement {

    companion object {

        /**
         * Creates a static version of this element as a raw HTML element.
         */
        fun HtmlElement.static(): RawHtmlElement = RawHtmlElement(toString())
    }

    override fun toString(): String {

        return value
    }

    override fun toPrettyString(): String {

        return value
    }
}
