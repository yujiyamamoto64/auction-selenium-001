# language: pt

Funcionalidade: Propondo lances ao leilao
  
  Cenário: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe o lance
    Entao o lance eh aceito
    
  Cenário: Propondo varios lances validos
  	Dado um lance de 10.0 reais do usuario "fulano"
  	E um lance de 15.0 reais do usuario "beltrano"
  	Quando propoe varios lances ao leilao
  	Entao os lances sao aceitos