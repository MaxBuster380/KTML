/*
 * MIT License
 *
 * Copyright (c) 2024 MaxBuster
 *
 * This is the "CssProperties.kt" file from the KTML project.
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
 * # CssProperties
 *
 * CSS properties is a set of CSS style rules.
 *
 * ```css
 * div.myClass {
 *
 *  /* These together form a CSSProperties element. */
 *  color: red;
 *  background: blue;
 * }
 * ```
 */
class CssProperties(
    private val attributes: HashMap<String, String> = hashMapOf(),
) : WebElement, Map<String, String> {

    constructor(vararg bindings: Pair<String, String>) : this(hashMapOf()) {

        for (binding in bindings)
            attributes[binding.first] = binding.second
    }

    override val entries: Set<Map.Entry<String, String>> get() = attributes.entries
    override val keys: Set<String> get() = attributes.keys
    override val size: Int get() = attributes.size
    override val values: Collection<String> get() = attributes.values

    override fun isEmpty(): Boolean = attributes.isEmpty()

    override fun get(key: String): String? = attributes[key]

    override fun containsValue(value: String): Boolean = attributes.containsValue(value)

    override fun containsKey(key: String): Boolean = attributes.containsKey(key)

    operator fun set(name: String, value: String) {

        attributes[name] = value
    }

    fun unsetProperty(name: String) {

        attributes.remove(name)
    }

    override fun toString(): String {

        return attributeLines().joinToString("")
    }

    override fun toPrettyString(): String {

        return attributeLines().joinToString("\n")
    }

    private fun attributeLines(): List<String> {

        return attributes.map { "${it.key}: ${it.value};" }
    }

}