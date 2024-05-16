const fs = require('fs');
const path = require('path');

const inputFilePath = path.join(__dirname, 'text.txt');
const outputFilePath = path.join(__dirname, 'output.txt');

function isVowel(char) {
    const vowels = 'аеёиоуыэюяАЕЁИОУЫЭЮЯ';
    return vowels.includes(char);
}

function isConsonant(char) {
    const consonants = 'бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ';
    return consonants.includes(char);
}

let vowelCount = 0;
let consonantCount = 0;

fs.readFile(inputFilePath, 'utf8', (err, data) => {
    if (err) {
        console.error('Ошибка при чтении файла:', err);
        return;
    }

    const transformedData = data.split('').map(char => {
        if (isVowel(char)) {
            vowelCount++;
            return 'a';
        } else if (isConsonant(char)) {
            consonantCount++;
            return 'м';
        } else {
            return char; 
        }
    }).join('');

    fs.writeFile(outputFilePath, transformedData, 'utf8', (err) => {
        if (err) {
            console.error('Ошибка при записи файла:', err);
            return;
        }
        console.log('Файл успешно записан.');

        console.log(`Количество гласных: ${vowelCount}`);
        console.log(`Количество согласных: ${consonantCount}`);
    });
});