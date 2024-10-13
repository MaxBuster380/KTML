/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "CssStyle.kt" file from the KTML project.
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

/**
 * # CssStyle
 *
 * A CSS style is a set of conditional style rules that are applied to an HTML document.
 *
 * ```css
 * /* This is a whole example of CSS style. */
 *
 * h1 {
 *  color: red;
 * }
 *
 * p.large {
 *  font-size: 3rem;
 * }
 *
 * @media screen and (max-width: 800px) {
 *  h1 {
 *   font-size: 1rem;
 *  }
 * }
 * ```
 */
data class CssStyle(
    val scopes: MutableSet<CssScope> = mutableSetOf(),
) : WebElement {

    constructor(vararg scopes: CssScope) : this(scopes.toMutableSet())

    fun isEmpty(): Boolean = scopes.isEmpty()

    fun isNotEmpty(): Boolean = scopes.isNotEmpty()

    override fun toString(): String {

        return scopes.joinToString("")
    }

    override fun toPrettyString(): String {

        return scopes.joinToString("\n\n") { it.toPrettyString() }
    }
}

