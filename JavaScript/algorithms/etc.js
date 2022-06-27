function evil(fn) {
  return new Function("return " + fn)();
}
