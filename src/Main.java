//a
static boolean randomBoolean() {
    return Math.random() <= 0.5;
}

//b
static int divisors(int n) {
    int div = n;
    int count = 0;

    while (div != 0) {
        if (n % div == 0) {
            count = count + 1;
        }
        div = div -1;
    }
    return count;
}

//c
static int randomNumberUpTo(int n) {
    return  (int) (Math.random() * n);
}

//d
static char randomVowel() {
    // intervalo entre 97, 100, 105, 111, 117;
    int random;
    do {
        random = (int) (Math.random() * ((117 - 97) + 1)) + 97;
    } while (random != 97 && random != 101 && random != 105 && random != 111 && random != 117);
    return (char) random;
}

//e


void main() {
    IO.println("Exercício a - Verdadeiro ou falso: " + randomBoolean());
    IO.println("Exercício b - : Número de divisores: " + divisors(8));
    IO.println("Exercício c - : Número máximo: " + randomNumberUpTo(5));
    IO.println("Exercício d - : Vogal: " + randomVowel());
    


}
