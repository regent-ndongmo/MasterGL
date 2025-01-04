<!--

  DO NOT EDIT.

  This markdown file was autogenerated using a mixture of the following files as the source of truth for its data:
  - ../../src/rules/attributes-order.ts
  - ../../tests/rules/attributes-order/cases.ts

  In order to update this file, it is therefore those files which need to be updated, as well as potentially the generator script:
  - ../../../../tools/scripts/generate-rule-docs.ts

-->

<br>

# `@angular-eslint/template/attributes-order`

Ensures that HTML attributes and Angular bindings are sorted based on an expected order

- Type: layout
- 🔧 Supports autofix (`--fix`)

<br>

## Rule Options

The rule accepts an options object with the following properties:

```ts
interface Options {
  alphabetical?: boolean;
  /**
   * Default: `["STRUCTURAL_DIRECTIVE","TEMPLATE_REFERENCE","ATTRIBUTE_BINDING","INPUT_BINDING","TWO_WAY_BINDING","OUTPUT_BINDING"]`
   *
   * @minItems 6
   */
  order?: [
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    (
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    ),
    ...(
      | "STRUCTURAL_DIRECTIVE"
      | "TEMPLATE_REFERENCE"
      | "ATTRIBUTE_BINDING"
      | "INPUT_BINDING"
      | "TWO_WAY_BINDING"
      | "OUTPUT_BINDING"
    )[]
  ];
}

```

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
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<li><input type="text" id="input"></li>
           ~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input #inputRef *ngIf="flag" class="className">
       ~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngIf="flag" class="className" #inputRef [binding]="true" [(ngModel)]="model" (output)="handleOutput($event)">
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngFor="inputs" [binding]="true" class="className" (output)="handleOutput($event)">
                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngIf="flag" #inputRef class="className" [(ngModel)]="model" [binding]="true" (output)="handleOutput($event)">
                                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngIf="flag" #inputRef class="className" (output)="handleOutput($event)" [binding]="true">
                                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Custom Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error",
      {
        "alphabetical": false,
        "order": []
      }
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngIf="flag" class="className">
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Custom Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error",
      {
        "alphabetical": true,
        "order": []
      }
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input *ngIf="flag" [(ngModel)]="model" #inputRef id="input" class="className" [binding]="true" (output)="handleOutput($event)">
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<input
  [(ngModel)]="model"
  ~~~~~~~~~~~~~~~~~~~
  *ngIf="flag"
  ~~~~~~~~~~~~
  #inputRef
  ~~~~~~~~~
  id="input"
  ~~~~~~~~~~
  class="className"
  ~~~~~~~~~~~~~~~~~
  (output)="handleOutput($event)"
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  [binding]="true">
  ~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<ng-container (click)="bar = []" id="issue" *ngFor="let foo of bar"></ng-container>
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<ng-container (click)="bar = []" id="issue" *ngFor="let foo of bar; index as i; first as isFirst"></ng-container>
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div id="id" *ngIf="bar as foo"></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div id="id" *ngIf="condition then foo else bar"></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div [disabled]="disabled" [class.disabled]="disabled"></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<ng-template let-value #Template></ng-template>
             ~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<ng-template let-value="something" let-anotherValue="else" #Template></ng-template>
             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<td mat-cell *matCellDef="let element"></td>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<td mat-cell *matCellDef="
    ~~~~~~~~~~~~~~~~~~~~~~
  let element
  ~~~~~~~~~~~
"></td>
~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div class="abc" *ngIf="sth.property as property "></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Custom Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error",
      {
        "alphabetical": true,
        "order": []
      }
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div *structuralDirective class="abc"></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div title="abc" *structuralDirective abbr="abc"></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ❌ Invalid Code

```html
<div class="abc" *structuralDirective></div>
     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input class="card" [value]="foo" (valueChange)="handleValueChange($event)">
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input *ngIf="flag" #inputRef id="input" class="className" [binding]="true" [(ngModel)]="model" (output)="handleOutput($event)">
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input *ngIf="flag" (output)="handleOutput($event)">
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input *ngIf="flag" required>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input [(ngModel)]="model">
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<input [(ngModel)]="model" (ngModelChange)="onChange($event)">
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<ng-template></ng-template>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<ng-template #Template><div></div></ng-template>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<ng-template [ngIf]="condition" [ngIfThen]="If" [ngIfElse]="Else"><div></div></ng-template>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<ng-template #Template let-value><div></div></ng-template>
```

<br>

---

<br>

#### Default Config

```json
{
  "rules": {
    "@angular-eslint/template/attributes-order": [
      "error"
    ]
  }
}
```

<br>

#### ✅ Valid Code

```html
<div i18n test1="test1" i18n-test1="@@TEST1" test2="test2" i18n-test2="@@TEST2"></div>
```

</details>

<br>