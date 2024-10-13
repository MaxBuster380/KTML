/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlTag.kt" file from the KTML project.
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

import web.html.HtmlElement

/**
 * # HtmlTag
 *
 * An HTML tag is the base unit in HTML.
 *
 * ```html
 * <html> <!-- This is an HTMLContentTag -->
 *
 *     <head>
 *          <meta charset="utf-8"> <!-- This is an HTMLTag -->
 *     </head>
 *
 *     <body>
 *          <style></style> <!-- This is an HTMLStyleTag -->
 *
 *          <script></script> <!-- This is an HTMLScriptTag -->
 *      </body>
 * </html>
 * ```
 */
interface HtmlTag : HtmlElement {

    /**
     * # HtmlTag.name
     *
     * Title of the tag.
     *
     * ```html
     * <!-- "p" is the name of the tag. -->
     * <p>Lorem ipsum</p>
     * ```
     */
    val name: String
}