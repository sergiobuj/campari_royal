require 'drb'
require 'aux'

## Casino
class Casino
  @tables = []
  @gamblers = {}
  @gamblers_table = {}

  # gambler id, gambler url
  def login gid, gurl
    @gamblers[gid] = gurl
  end

  def logout gid
    gamblers.reject! { |id, gambler| id == gid }
  end
  
  def cambio_mesa gid, new_table
    
  end  

  def initialize
    (1..10).each { |id| @tables << Table.new id }
  end

end

DRb.start_service nil, Casino.new
puts DRb.uri
DRb.thread.join
