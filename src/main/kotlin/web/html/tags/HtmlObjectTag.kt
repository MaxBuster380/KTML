/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "HtmlObjectTag.kt" file from the KTML project.
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

import web.css.CssProperties

/**
 * # HtmlObjectTag
 *
 * An HTML tag is a content-less HTML tag.
 *
 * ```html
 * <html>
 *     <head>
 *          <meta charset="utf-8"> <!-- This is an HTMLTag -->
 *     </head>
 * </html>
 * ```
 */
open class HtmlObjectTag(
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
    var id: String? = null,
    /**
     * # HtmlObjectTag.classes
     *
     * Generalized identifiers for the tag.
     *
     * ```html
     * <!-- The classes of the "div" tag are "lorem" and "ipsum". -->
     * <div class="lorem, ipsum">
     * ```
     */
    val classes: MutableSet<String> = mutableSetOf(),
    /**
     * # HtmlObjectTag.attributes
     *
     * Extra properties of the tag.
     *
     * ```html
     * <!-- "href" is an attribute. -->
     * <a href="./icon.png">
     * ```
     */
    private val attributes: HashMap<String, String> = hashMapOf(),
    /**
     * # HtmlObjectTag.style
     *
     * CSS style rules specific to the tag.
     *
     * ```html
     * <!-- The div tag's style is the CSS "display:flex; color:red;". -->
     * <div style="display:flex;color:red;">
     * ```
     */
    val style: CssProperties = CssProperties(),
) : HtmlTag {

    private var _name: String = name
    override var name: String
        get() = _name
        set(newName) {
            if (newName == "script")
                throw IllegalStateException("Can't create an HtmlTag of name \"script\". Use HtmlScript instead.")

            if (newName == "style")
                throw IllegalStateException("Can't create an HtmlTag of name \"style\". Use HtmlStyle instead.")

            _name = newName
        }

    init {

        if (name == "script")
            throw IllegalStateException("Can't create an HtmlTag of name \"script\". Use HtmlScript instead.")

        if (name == "style")
            throw IllegalStateException("Can't create an HtmlTag of name \"style\". Use HtmlStyle instead.")

        if (attributes.containsKey("id"))
            throw IllegalStateException("Can't define 'id' in properties, use the 'id' class attribute instead.")

        if (attributes.containsKey("class"))
            throw IllegalStateException("Can't define 'class' in properties, use the 'classes' class attribute instead.")

        if (attributes.containsKey("style"))
            throw IllegalStateException("Can't define 'style' in properties, use the 'style' class attribute instead.")

        checkForPropertyEdit { attributes.containsKey(it) }
    }

    /**
     * # HtmlObjectTag.get
     *
     * Returns the tag's value for a given property.
     *
     * @param name Property name
     *
     * @return The value of the property if defined, null if undefined.
     */
    operator fun get(name: String): String? {

        return attributes[name]
    }

    /**
     * # HtmlObjectTag.set
     *
     * Sets a new value for a tag property.
     *
     * @param name Property name
     * @param value New value of the property
     */
    operator fun set(name: String, value: String) {

        checkForPropertyEdit { name == it }

        attributes[name] = value
    }

    /**
     * # HtmlObjectTag.unsetProperty
     *
     * Removes a property from the tag.
     *
     * @param name Property name
     */
    fun unsetProperty(name: String) {

        attributes.remove(name)
    }

    override fun toString(): String {

        return "<${headContent()}>"
    }

    override fun toPrettyString(): String = toString()

    protected fun headContent(): String {

        val stringBuilder = StringBuilder()

        stringBuilder.append(name)

        if (id != null)
            stringBuilder.append(" id=\"$id\"")

        if (classes.isNotEmpty()) {

            stringBuilder.append(
                " class=\"${classes.joinToString(",")}\""
            )
        }

        if (style.isNotEmpty()) {

            stringBuilder.append(
                " style=\"$style\""
            )
        }

        if (attributes.isNotEmpty()) {

            for (key in attributes.keys) {

                stringBuilder.append(" $key=\"${attributes[key]}\"")
            }
        }

        return stringBuilder.toString()
    }

    private fun checkForPropertyEdit(test: (String) -> Boolean) {

        if (test.invoke("id"))
            throw IllegalStateException("Can't define 'id' in properties, use the 'id' class attribute instead.")

        if (test.invoke("class"))
            throw IllegalStateException("Can't define 'class' in properties, use the 'classes' class attribute instead.")

        if (test.invoke("style"))
            throw IllegalStateException("Can't define 'style' in properties, use the 'style' class attribute instead.")

    }
}
