### Table
class Table

  @table_id

  K_NO_COLOR = -1
  K_RED_COLOR = 0
  K_BLACK_COLOR = 1
  K_RED_OPTION  = 38
  K_BLACK_OPTION = 39
  K_ODD_OPTION = 40
  K_EVEN_OPTION = 41

  def initialize id_given
    @table_id = id_given
  end

  def spin_roulette
    result = -1
    result = ( rand * 38 ).floor unless bets.empty?
  end

  def color_for_number number
    color = K_NO_COLOR
    if ( number >= 29 and number < 37 ) or ( number >= 11 and number < 19 )
      color = number % 2 == 0 ? K_RED_COLOR : K_BLACK_COLOR
    end    
    if ( number >= 19 and number < 29 ) or ( number >= 1 and number <11 )
      color = number % 2 == 0 ? K_BLACK_COLOR : K_RED_COLOR
    end
    color    
  end

  
  def pay_bets_to_result result
    @payouts = {}
    @bets.each do |bet|
      bet_option = bet.option
      payout = 0.0
      
      case bet_option
        
      when K_RED_OPTION
        if K_RED_COLOR == color_for_number( result )
          payouts[bet.gambler_id] += ( bet.value / 18.0 ) * 36.0
        end
      when K_BLACK_OPTION
        if K_BLACK_COLOR == color_for_number( result )
          payouts[bet.gambler_id] += (bet.value / 18.0 ) * 36.0
        end          
      when K_EVEN_OPTION
        if result % 2 == 0
          payouts[bet.gambler_id] += (bet.value / 18.0 ) * 36.0
        end   
      when K_ODD_OPTION

        if result % 2 != 0
          payouts[bet.gambler_id] += (bet.value / 18.0 ) * 36.0
        elsif bet_option >= 0 and bet_option <= 37 and bet_option == result
          payouts[bet.gambler_id] += bet.value * 36.0        
        end
        
      end
    end      
    @bets = []
  end

  attr_reader :table_id  
end


### Bets
class Bet

  def initialize gambler, bet_value, bet_option
    @gambler_id = gambler
    @value = bet_value
    @option = bet_option
  end

end
