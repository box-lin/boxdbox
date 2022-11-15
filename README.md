<div id="top" align="center">   
  
  ![](Document/name.png)
Box and Unbox your file through **Huffman Coding Algorithm** and **SHA256 Hashing** 

![](https://img.shields.io/badge/license-MIT-yellow.svg)
![](https://img.shields.io/badge/language-java-pink.svg)
![](https://img.shields.io/badge/build-passed-green.svg)
![](https://img.shields.io/badge/software-released-blue.svg)
![](https://img.shields.io/badge/document-ready-purple.svg)
![](https://img.shields.io/badge/opensoure-yes-brown.svg) 
</div>
  
---

 
## Software Architecture
![](Document/newBox.drawio.png)

## Milestone 1
- [x] Software Design
- [x] Graphical User Interfaces
- [x] Huffman Tree Node 

## Milestone 2
- [x] Algorithm to build HuffmanTree completed.
- [x] Translated HuffmanTree to HuffmanTable
- [x] Translated Byte Array from input file to Huffman Code string completed.
- [x] Hashing with SHA256 completed.
- [x] Object serialization completed, serialized a packet that consists of HuffmanTable, HuffmanCode, and SHA256Hashed Password.
- [x] Encryption Reader that reads bytes from the file completed.
- [x] Encryption Writer that writes a packet to the file completed.
- [x] Encrypter wrapper class completed.
- [x] Decryption Reader that reads a packet from the file completed.
- [x] Decryption Writer that writes original bytes to the file completed.
- [x] Decryption algorithm that greedy compute the original byte from Huffmancode and Huffmantable completed.
- [x] MainWindow Action Listeners for load, box, unbox buttons implemented.
- [x] MainWindow Keyboard listeners for secrete key implemented.
- [x] Icons for UI components added.

## Major Subcomponents Description
- **Packet Builder**
  - Packet Builder build the Huffman Tree from the original byte array read from the input file. Then build the Huffman Table according to the Huffman Tree. Finally, build the Huffman Code String from Huffman Table and original byte array. Huffman Code String is the encoded string that describes the original byte array in a secret way.



