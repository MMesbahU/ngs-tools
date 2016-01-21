/* ===========================================================================
#
#                            PUBLIC DOMAIN NOTICE
#               National Center for Biotechnology Information
#
#  This software/database is a "United States Government Work" under the
#  terms of the United States Copyright Act.  It was written as part of
#  the author's official duties as a United States Government employee and
#  thus cannot be copyrighted.  This software/database is freely available
#  to the public for use. The National Library of Medicine and the U.S.
#  Government have not placed any restriction on its use or reproduction.
#
#  Although all reasonable efforts have been taken to ensure the accuracy
#  and reliability of the software and data, the NLM and the U.S.
#  Government do not and cannot warrant the performance or results that
#  may be obtained by using this software or data. The NLM and the U.S.
#  Government disclaim all warranties, express or implied, including
#  warranties of performance, merchantability or fitness for any particular
#  purpose.
#
#  Please cite the author in any work or product based on this material.
#
=========================================================================== */
package GUI;

import data.CLogger;
import data.Settings;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class main_window_runner implements Runnable
{
    static void set_look_and_feel()
    {
        try
        {
            //UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        }
        catch ( ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException | 
                UnsupportedLookAndFeelException e )
        {
        }
    }

    @Override public void run()
    {
        if ( Settings.getInstance().is_valid() )
        {
            CLogger.start( "log.txt",
                           "sra-dnld-mgr",
                           Settings.getInstance().get_log_to_file(),
                           Settings.getInstance().get_log_to_cons()
                           );
            CLogger.log( "Start Application" );
            
            set_look_and_feel();
        
            MainWindow main_window = new MainWindow();
            
            SettingsWindow.make_instance( main_window );
            JobWindow.make_instance( main_window );
            AccessionWindow.make_instance( main_window );
            PreviewWindow.make_instance( main_window );
            FilterWindow.make_instance( main_window );
            ReferenceWindow.make_instance( main_window );
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Settings invalid",
                    "Error", JOptionPane.INFORMATION_MESSAGE );
        }
    }
}

public class SRA_DNLD_MGR
{
    public static void main( String[] args )
    {
        main_window_runner mwr = new main_window_runner();
        javax.swing.SwingUtilities.invokeLater( mwr );
    }
}
