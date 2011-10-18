
class WfilesController < ApplicationController
  # GET /wfiles
  # GET /wfiles.xml
  def index
    @wfiles = []
    @files_ = []
	
    [ HTTParty.get("http://localhost:3000/ficheros") , HTTParty.get("http://localhost:3001/ficheros") ].each { | serv | 
    
    arr = serv.split("sN3r0l")
    
    @wfiles = arr.map { |x|
      arr2 = x.split("=>")
      Wfile.new arr2[0] , arr2[1]
    }
	

	@files_ = @files_ | @wfiles
	

  }
    
    #logger.info(@files_)
    
    respond_to do |format|
      format.html # index.html.erb
      format.xml  { render :xml => @files_ }
    end
  end

  # GET /wfiles/1
  # GET /wfiles/1.xml
  def show
    if params[:type].nil? 
       @wfiles = []
        llega = HTTParty.get("http://localhost:3000/ficheros/#{params[:id]}")

        arr = llega.split("sN3r0l")

        @wfiles = arr.map { |x|
          arr2 = x.split("=>")
          Wfile.new arr2[0] , arr2[1]
        }
    else
 
      send_data HTTParty.get("http://localhost:3000/ficheros/#{params[:id]}")
 
    
    # @wfile = Wfile.find(params[:id])
    #  
    #  respond_to do |format|
    #    format.html # show.html.erb
    #    format.xml  { render :xml => @wfile }
 
    end
  end


end
