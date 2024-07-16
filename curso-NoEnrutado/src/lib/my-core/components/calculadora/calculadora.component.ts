/* eslint-disable @typescript-eslint/no-unused-expressions */
import { Component } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent {
  currentNumber = '0';
  firstOperand = NaN;
  operator = '';
  waitForSecondNumber = false;
  currentDisplay = '0';

  getNumber(v: string) {
    if (this.waitForSecondNumber) {
      this.currentNumber = v;
      this.waitForSecondNumber = false;
    } else {
      this.currentNumber === '0' ? this.currentNumber = v : this.currentNumber += v;
    }
    this.updateDisplay();
  }

  getDecimal() {
    if (!this.currentNumber.includes(',')) {
      this.currentNumber += ',';
    }
    this.updateDisplay();
  }

  getOperation(op: string) {
    if (isNaN(this.firstOperand)) {
      this.firstOperand = parseFloat(this.currentNumber.replace(',', '.'));
      
    } else if (this.operator) {
      const result = this.doCalculation(this.operator, parseFloat(this.currentNumber.replace(',', '.')));
      this.currentNumber = String(result.toFixed(20)).replace('.', ',');
      this.firstOperand = Number(result.toFixed(20));
    }
    this.operator = op;
    this.waitForSecondNumber = true;
    this.updateDisplay();
  }

  doCalculation(op: string, secondOp: number) {
    switch (op) {
      case '+':
        return this.firstOperand += secondOp;
      case '-':
        return this.firstOperand -= secondOp;
      case '*':
        return this.firstOperand *= secondOp;
      case '/':
        return this.firstOperand /= secondOp;
      case '=':
        return secondOp;
      default:
        return NaN;
    }
  }

  clear() {
    this.currentNumber = '0';
    this.firstOperand = NaN;
    this.operator = '';
    this.waitForSecondNumber = false;
    this.currentDisplay = '0';
  }

  toggleSign() {
    this.currentNumber = String(parseFloat(this.currentNumber.replace(',', '.')) * -1).replace('.', ',');
    this.updateDisplay();
  }

  percentage() {
    this.currentNumber = String(parseFloat(this.currentNumber.replace(',', '.')) / 100).replace('.', ',');
    this.updateDisplay();
  }

  updateDisplay() {
    if(this.operator === '='){
      this.currentDisplay = this.currentNumber.replace('.', ',');
    }
    else{
      this.currentDisplay = this.operator ? `${this.firstOperand}`.replace('.',',') + `${this.operator} ${this.currentNumber}` : this.currentNumber;
    }
  }
}
