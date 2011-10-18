require 'drb'
require 'aux'

## Gambler
class Gambler
  @money

end

DRb.start_service nil, Gambler.new
casino = DRbObject.new nil, ARGV.shift
