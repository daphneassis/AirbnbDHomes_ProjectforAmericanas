# AirbnbDHomes_ProjectforAmericanas
Airbnb-like system for renting apartments for Lojas Americanas' POO1 module.

*Em Português*
Trata-se de um projeto de locação de apartamentos semelhante ao Airbnb. 
A reserva pode ser feita por hóspedes e empresas, os dados são guardados em duas listagens de cadastros próprios para usos do Marketing. 
Ao final do preenchimento dos dados da reserva como apartamento, datas de check-in e check-out, o sistema calcula o preço com base no número de diárias, na estação (meses de baixa ou alta temporada) e descontos sobre estadias de longa duração e empresa, se aplicável. 
O pagamento é realizado no check-in, mas deve-se informar o método de pagamento. 
Tais dados da reserva completa são gravados em duas novas listas. 
Por fim, há um menu dividido em hóspedes e empresas, que traz as opções: ver todas as reservas, todas as informações de contato, atualizar datas da reserva e email pelo documento de identidade cadastrado e a opção de deletar a reserva da lista.

Como o programa foi estruturado (detalhes;):
Trabalha-se com herança e polimorfismo nas classes Guest e GuestCompany e GuestIndividual, as últimas servirão de cadastro para o Marketing. 
Utiliza-se o Builder para popular objetos. 
Em ReservationDates, há uso do try and catch com algumas regras: as datas de reserva precisam ser posteriores à data atual, a data de check-in precisa ser anterior ao checkout e não aceita inserção de dados em outro formato que não o especificado. 
A classe Price calcula o preço final levando em conta descontos sobre a duração da estadia (se maior que 7 dias), meses de alta ou baixa temporada (identificados na classe SeasonService) e se a reserva é feita por empresa (através de função na classe ValidationCompany).
 Há um menu de enums em MethodosOfPayments, com a descrição da forma de pagamento e opção a ser registrada no sistema. 
As listas GuestCompanyFullData e GuestIndivFullData guardam todos os dados registrados até então.
 Como regra de negócio, a opção adicionar Reserva já é automática, mas no Menu é possível conferir os registros feitos, atualizar e remover reservas.
 Este Menu é dividido em opções de hóspedes e companhias, que permite escolher ver:
 (1) toda a informação da reserva com informações do hóspede, datas, preço final e método de pagamento; 
(2) remover a reserva de um hóspede pelo documento de identidade(id); 
(3) ver as informações de contato do hóspede para uso do Marketing; 
(4) atualizar a informação de contato do hóspede através do id(que atualiza automaticamente a lista de cadastro para marketing e a lista com todos os dados da reserva);
(5) atualizar as datas de reserva de um hóspede pelo id, que atualiza a lista com todos os dados da reserva. 
As mesmas opções estão disponíveis para as reservas feitas por empresas, nas opções de 6 a 10.
 A opção 2 de cancelar a reserva não apaga os dados cadastrais do hóspede/empresa, para que possam ser usados para contato e promoções pela área de Marketing. 
No final desse Menu, retorna à pergunta se deseja acrescentar mais alguma reserva ou finalizar o sistema. 

*In English*

This is an apartment rental project similar to Airbnb. 
The reservation can be made by guests and companies, and the data is stored in two registry listings for marketing uses. 
After filling in the reservation data such as apartment, check-in and check-out dates, the system calculates the price based on the number of days, season (low or high season months), and discounts on long stays and company, if applicable. 
Payment is made at check-in, but you must inform the payment method. 
Data from the complete reservation is saved in two new lists. 
Finally there is a menu divided into guests and companies, which brings the options: view all reservations, all contact information, update reservation dates and email by the registered identity document, and the option to delete the reservation from the list.

How the program was structured (details):
We work with inheritance and polymorphism in the Guest and GuestCompany and GuestIndividual classes, the latter will serve as a registration for Marketing. 
The Builder is used to populate objects. 
In ReservationDates, there is the use of try and catch with some rules: the reservation dates must be later than the current date, the check-in date must be earlier than the check-out date and it does not accept data insertion in any other format than the one specified. 
The Price class calculates the final price taking into account discounts on length of stay (if more than 7 days), high or low season months (identified in the SeasonService class) and whether the reservation is made per company (through a function in the ValidationCompany class).
 There is a menu of enums in MethodosOfPayments, with the description of the payment method and option to be registered in the system. 
The lists GuestCompanyFullData and GuestIndivFullData store all the data registered so far.
 As a business rule, the Add Booking option is already automatic, but in the Menu you can check the registrations made, update and remove bookings.
 This Menu is divided into guest and company options, which allows you to choose to view:
(1) all reservation information with guest information, dates, final price and payment method; 
(2) remove a guest's reservation by ID(id); 
(3) view the guest's contact information for Marketing use; 
(4) update the guest's contact information by id(which automatically updates the registration list for marketing and the list with all reservation data);
(5) update the reservation dates of a guest by id, which updates the list with all the reservation data. 
The same options are available for bookings made by companies, in options 6 to 10.
 The options 2 and 7 to cancel the reservation do not erase the registration data of the guest / company, so that they can be used for contact and promotions by the Marketing area. 
At the end of this Menu, returns to the question if you want to add any more reservations or end the system. 


