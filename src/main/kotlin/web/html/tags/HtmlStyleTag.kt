/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlStyleTag.kt" file from the KTML project.
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

package web.html.tags

import web.css.CssStyle
import web.html.HtmlElement.Companion.addIndent

/**
 * # HtmlStyleTag
 *
 * An HTML style tag is an HTML tag that adds CSS style rules to the document.
 *
 * ```html
 * <style>
 *   /* This is CSS code. */
 *   div {
 *     color: red;
 *   }
 * </style>
 * ```
 *
 * @see CssStyle
 */
data class HtmlStyleTag(
    val cssStyle: CssStyle,
) : HtmlTag {

    override val name: String
        get() = "style"

    override fun toString(): String {

        return "<style>${cssStyle}</style>"
    }

    override fun toPrettyString(): String {

        return "<style>\n${cssStyle.toPrettyString().addIndent()}\n</style>"
    }
}
