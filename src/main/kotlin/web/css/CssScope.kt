/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "CssScope.kt" file from the KTML project.
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

import web.WebElement
import web.html.HtmlElement.Companion.addIndent

/**
 * # CssScope
 *
 * A CSS scope is a list of style rules applied to a targeted set of HTML elements.
 *
 * ```css
 * /* This whole element is a CSS scope */
 * div.myClass {
 *
 *     /* These are properties. */
 *     color: red;
 *     background: blue;
 *
 *     /* This is a sub scope. */
 *     div {
 *         color: green;
 *     }
 *     p {
 *         color: yellow;
 *     }
 * }
 * ```
 *
 * @see CssScopeHead
 * @see CssProperties
 */
data class CssScope(
    val header: CssScopeHead,
    val properties: CssProperties = CssProperties(),
    val subScopes: MutableSet<CssScope> = mutableSetOf(),
) : WebElement {

    constructor(
        target: String,
        properties: CssProperties = CssProperties(),
        subScopes: MutableSet<CssScope> = mutableSetOf()
    ): this(
        header = CssScopeHeadTarget(target),
        properties = properties,
        subScopes = subScopes
    )

    override fun toString(): String {

        val stringBuilder = StringBuilder()

        stringBuilder.append(header)
        stringBuilder.append("{")

        stringBuilder.append(properties)

        if (subScopes.isNotEmpty())
            stringBuilder.append(
                subScopes.joinToString("") { it.toString() }
            )

        stringBuilder.append("}")

        return stringBuilder.toString()
    }

    override fun toPrettyString(): String {

        val stringBuilder = StringBuilder()

        stringBuilder.append(header)
        stringBuilder.append(" {\n")

        stringBuilder.append(
            properties
                .toPrettyString()
                .addIndent()
        )

        if (subScopes.isNotEmpty()) {

            stringBuilder.append("\n\t\n")

            stringBuilder.append(
                subScopes
                    .joinToString("\n\n") { it.toPrettyString() }
                    .addIndent()
            )
        }

        stringBuilder.append("\n}")

        return stringBuilder.toString()
    }
}
