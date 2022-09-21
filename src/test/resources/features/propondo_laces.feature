# language: pt

Funcionalidade: Propondo lances ao leilao
  
  Cenário: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe o lance
    Entao o lance eh aceito
    
  Cenário: Propondo varios lances validos
  	Dado varios lances validos
  	Quando propoe varios lances ao leilao
  	Entao os lances sao aceitos