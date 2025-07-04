package aeds3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ParTamEndereco implements RegistroHashExtensivel {

  private int tamRegistro;
  private long endereco;
  final private int TAMANHO = 12;

  public ParTamEndereco() {
    this(-1, -1);
  }

  public ParTamEndereco(int i, long e) {
    this.tamRegistro = i;
    this.endereco = e;
  }

  public int getTamRegistro() {
    return tamRegistro;
  }

  public long getEndereco() {
    return endereco;
  }

  public int hashCode() {
    return this.tamRegistro;
  }

  public short size() {
    return TAMANHO;
  }

  public byte[] toByteArray() throws IOException {
    ByteArrayOutputStream ba_out = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(ba_out);
    dos.writeInt(this.tamRegistro);
    dos.writeLong(this.endereco);
    return ba_out.toByteArray();
  }

  public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(ba_in);
    this.tamRegistro = dis.readInt();
    this.endereco = dis.readLong();
  }

}

