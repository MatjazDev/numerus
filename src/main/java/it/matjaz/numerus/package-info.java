/*
 * Copyright (c) 2015, Matjaž <dev@matjaz.it> matjaz.it
 *
 * This Source Code Form is part of the project Numerus, a roman numerals
 * library for Java. The library and its source code may be found on:
 * https://github.com/MatjazDev/Numerus and http://matjaz.it/numerus/
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/
 */
/**
 * This package contains the core classes and method of Numerus that allow
 * conversion and manipulation of roman numerals.
 * <p>
 * The classes have the word <i>Roman</i> in their names to be easilly
 * recognizable.
 * <p>
 * <ul>
 * <li>{@link it.matjaz.numerus.RomanNumeral RomanNumeral} is the representation
 * of a syntactically correct roman numeral. It's a container of the string with
 * the roman numeral, such as {@code "XLII"}, but it rejects numerals with wrong
 * syntax. It does <b>not</b> hold any other information, such as the value of
 * the roman numeral. Its only function is to ensure the correct syntax of a
 * roman numeral.</li>
 * <li>{@link it.matjaz.numerus.RomanInteger RomanInteger} holds a
 * {@link it.matjaz.numerus.RomanNumeral RomanNumeral} and its
 * {@link java.lang.Integer Integer} value tied toghether, continuously updating
 * one when the other gets changed (in both directions). The internal
 * conversions are performed by a
 * {@link it.matjaz.numerus.RomanConverter RomanConverter}, which is based on a
 * reference of roman characters generated by
 * {@link it.matjaz.numerus.RomanCharMapFactory RomanCharMapFactory}. Probably
 * this is one of the most useful classes, since it takes care of the
 * conversions.</li>
 * <li>{@link it.matjaz.numerus.RomanConverter RomanConverter} is an object
 * capable of bidirectional conversions roman numeral to/from
 * {@link java.lang.Integer Integer} with two separate methods. If you need just
 * a simple converter, this is it.</li>
 * <li>{@link it.matjaz.numerus.RomanCharMapFactory RomanCharMapFactory}
 * generates a reference for
 * {@link it.matjaz.numerus.RomanConverter RomanConverter} to be able to convert
 * the single roman characters in the numeral.</li>
 * </ul>
 */
package it.matjaz.numerus;
