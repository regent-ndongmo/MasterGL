<!--

  DO NOT EDIT.

  This markdown file was autogenerated using a mixture of the following files as the source of truth for its data:
  - ../../src/rules/click-events-have-key-events.ts
  - ../../tests/rules/click-events-have-key-events/cases.ts

  In order to update this file, it is therefore those files which need to be updated, as well as potentially the generator script:
  - ../../../../tools/scripts/generate-rule-docs.ts

-->

<br>

# `@angular-eslint/template/click-events-have-key-events`

[Accessibility] Ensures that the click event is accompanied with at least one key event keyup, keydown or keypress.

- Type: suggestion

<br>

## Rule Options

The rule does not have any configuration options.

<br>

## Usage Examples

> The following examples are generated automatically from the actual unit tests within the plugin, so you can be assured that their behavior is accurate based on the current commit.

<br>

<details>
<summary>❌ - Toggle examples of <strong>incorrect</strong> code for this rule</summary>

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" (handleSomething)="handleSomething()"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<header (click)="onClick()"></header>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<a (click)="onClick()"></a>
~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" aria-hidden="false"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" [attr.aria-hidden]="'false'"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" role="header"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" role="aside"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" [attr.role]="'header'"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" [attr.aria-hidden]="ariaHidden"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div (click)="onClick()" [attr.hidden]="hidden"></div>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

</details>

<br>

---

<br>

<details>
<summary>✅ - Toggle examples of <strong>correct</strong> code for this rule</summary>

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<div (click)="onClick()" (keyup)="onKeyup()"></div>
<div (keyup)="onKeyup()" (click)="onClick()"></div>
<div (click)="onClick()" (keyup)="onKeyup()" (handleSomething)="handleSomething()"></div>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<div (click)="onClick()" (keyup.enter)="onKeyup()"></div>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<cui-button (click)="onClick()"></cui-button>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<div (click)="onClick()" aria-hidden></div>
<div (click)="onClick()" aria-hidden="true"></div>
<div (click)="onClick()" [attr.aria-hidden]="true"></div>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<div (click)="onClick()" role="presentation"></div>
<div (click)="onClick()" [attr.role]="'none'"></div>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/click-events-have-key-events": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input (click)="onClick()">
<button (click)="onClick()"></button>
<textarea (click)="onClick()"></textarea>
<select (click)="onClick()">
  <option (click)="onClick()"></option>
</select>
<textarea (click)="onClick()"></textarea>
<a href="#" (click)="onClick()"></a>
<a [attr.href]="href" class="anchor" (click)="onClick()"></a>
<a [routerLink]="'route'" (click)="onClick()"></a>
```

</details>

<br>