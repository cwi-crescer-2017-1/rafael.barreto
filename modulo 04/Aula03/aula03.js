// classes em javascript.


function SerieDeTv(nome, anoEstreia){
  this.nome = nome || 'NI';
  this.anoEstreia = anoEstreia;
}

SerieDeTv.prototype.imprimirNome(){console.log (this.nome.toUpperCase())}
