import { RuleTester } from '@angular-eslint/test-utils';
import rule, {
  RULE_NAME,
} from '../../../src/rules/mouse-events-have-key-events';

import { invalid, valid } from './cases';

const ruleTester = new RuleTester({
  languageOptions: {
    parser: require('@angular-eslint/template-parser'),
  },
});

ruleTester.run(RULE_NAME, rule, {
  valid,
  invalid,
});