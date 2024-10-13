/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlContentTag.kt" file from the KTML project.
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

package fr.maxbuster.web.html.tags

import web.css.CssProperties
import web.html.HtmlElement
import web.html.HtmlElement.Companion.addIndent
import web.html.tags.HtmlObjectTag

/**
 * # HtmlContentTag
 *
 * An HTML content tag is an HTML tag that has sub elements.
 *
 * ```html
 * <!-- The tags "div", "h1" and "p" are all HTML content tags. -->
 * <div>
 *     <h1>Title</h1>
 *     <p>Lorem ipsum </p>
 * </div>
 * ```
 *
 * This class is not used to represent "style" and "script" tags, use HtmlStyleTag and HtmlScriptTag respectively.
 *
 * @see HtmlObjectTag
 * @see HtmlStyleTag
 * @see HtmlScriptTag
 */
class HtmlContentTag(
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
    name: String,
    /**
     * # HtmlObjectTag.id
     *
     * Identifier of the tag, unique in the document.
     *
     * ```html
     * <!-- The id of the "div" tag is "lorem". -->
     * <div id="lorem"/>
     * ```
     */
    id: String? = null,
    /**
     * # HtmlObjectTag.classes
     *
     * Generalized identifiers for the tag.
     *
     * ```html
     * <!-- The classes of the "div" tag are "lorem" and "ipsum". -->
     * <div class="lorem, ipsum"/>
     * ```
     */
    classes: MutableSet<String> = mutableSetOf(),
    /**
     * # HtmlObjectTag.attributes
     *
     * Extra properties of the tag.
     *
     * ```html
     * <!-- "href" is an attribute. -->
     * <a href="./icon.png"/>
     * ```
     */
    attributes: HashMap<String, String> = hashMapOf(),
    /**
     * # HtmlObjectTag.style
     *
     * CSS style rules specific to the tag.
     *
     * ```html
     * <!-- The div tag's style is the CSS "display:flex; color:red;". -->
     * <div style="display:flex;color:red;"/>
     * ```
     */
    style: CssProperties = CssProperties(),
    /**
     * # HtmlContentTag.content
     *
     * Sub elements of the tag, organized first to last.
     *
     * ```html
     * <!-- [<h1>Title</h1>, <p>Lorem ipsum </p>] is the content of the div tag. -->
     * <div>
     *     <h1>Title</h1>
     *     <p>Lorem ipsum</p>
     * </div>
     * ```
     */
    val content: MutableList<HtmlElement>,
) : HtmlObjectTag(
    name = name,
    id = id,
    classes = classes,
    attributes = attributes,
    style = style
) {

    constructor(
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
        name: String,
        /**
         * # HtmlObjectTag.id
         *
         * Identifier of the tag, unique in the document.
         *
         * ```html
         * <!-- The id of the "div" tag is "lorem". -->
         * <div id="lorem"/>
         * ```
         */
        id: String? = null,
        /**
         * # HtmlObjectTag.classes
         *
         * Generalized identifiers for the tag.
         *
         * ```html
         * <!-- The classes of the "div" tag are "lorem" and "ipsum". -->
         * <div class="lorem, ipsum"/>
         * ```
         */
        classes: MutableSet<String> = mutableSetOf(),
        /**
         * # HtmlObjectTag.attributes
         *
         * Extra properties of the tag.
         *
         * ```html
         * <!-- "href" is an attribute. -->
         * <a href="./icon.png"/>
         * ```
         */
        attributes: HashMap<String, String> = hashMapOf(),
        /**
         * # HtmlObjectTag.style
         *
         * CSS style rules specific to the tag.
         *
         * ```html
         * <!-- The div tag's style is the CSS "display:flex; color:red;". -->
         * <div style="display:flex;color:red;"/>
         * ```
         */
        style: CssProperties = CssProperties(),
        /**
         * # HtmlContentTag.content
         *
         * Sub elements of the tag, organized first to last.
         *
         * ```html
         * <!-- [<h1>Title</h1>, <p>Lorem ipsum </p>] is the content of the div tag. -->
         * <div>
         *     <h1>Title</h1>
         *     <p>Lorem ipsum</p>
         * </div>
         * ```
         */
        content: HtmlElement? = null,
    ) : this(
        name = name,
        id = id,
        classes = classes,
        style = style,
        attributes = attributes,
        content = mutableListOf()
    ) {

        if (content != null) this.content += content
    }

    override fun toString(): String {

        if (content.isEmpty())
            return singleLineHead()

        val stringBuilder = StringBuilder()

        stringBuilder.append(head())

        stringBuilder.append(
            content
                .joinToString("") { it.toString() }
        )

        stringBuilder.append(foot())

        return stringBuilder.toString()
    }

    override fun toPrettyString(): String {

        if (content.isEmpty())
            return singleLineHead()

        val stringBuilder = StringBuilder()

        stringBuilder.append(head() + "\n")

        stringBuilder.append(
            content
                .joinToString("\n") { it.toPrettyString() }
                .addIndent()
        )

        stringBuilder.append("\n" + foot())

        return stringBuilder.toString()
    }

    private fun head(): String {

        return "<${headContent()}>"
    }

    private fun foot(): String {

        return "</$name>"
    }

    private fun singleLineHead(): String {

        return "<${headContent()}/>"
    }

}
